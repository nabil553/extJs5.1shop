Ext.define('sa.controller.HomeController',{
	extend:'Ext.app.Controller',
	views:['Viewport'],
	config:{
		control:{
			'leftpanel treepanel':{
				select:'onMenuSelectForRout'
			}
		},
		refs:{
			leftPanel:'leftpanel',
			contentPanel:'content-panel'
		},
		routes : {
    		':id'  : {
    			action  : 'handleRout',
        		before  : 'beforeHandleRout'
    		}
		}
	},
	
	findNode : function(id){
    	var me = this,
    		leftPanel = me.getLeftPanel(),
    		menuTrees = leftPanel.query('treepanel'),
    		node = null;
    	Ext.Array.each(menuTrees,function(menuTree){
    		var store = menuTree.getStore();
    		node = store.getNodeById(id);
    		if (node)
    			return false;
    	});
		return node;
    },
    findAndFocusNode : function(id){
    	var me = this,
    		leftPanel = me.getLeftPanel(),
    		menuTrees = leftPanel.query('treepanel'),
    		node = null;
    	Ext.Array.each(menuTrees,function(menuTree){
    		var store = menuTree.getStore();
    		node = store.getNodeById(id);
    		if (node){
    			menuTree.getSelectionModel().select(node);//选中tree里面的数据
    			menuTree.getView().focusNode(node); //视觉上呈现出聚焦的状态 
    			return false;
    		}
    	});
		return node;    	
    },
    
    handleRout : function(id){
    	var me = this,
    		node = me.findAndFocusNode(id),
    		contentPanel = me.getContentPanel(),
    		moduleId = id;
  		var className = Ext.ClassManager.getNameByAlias('widget.'+moduleId);
    	var ViewClass = Ext.ClassManager.get(className);
    	var module = new ViewClass();
    	Ext.suspendLayouts(); //暂停布局
    	module = Ext.apply(module,{
    		itemId : id,
    		closable : true,
    		glyph : node.get('glyph'),
    		title : node.get('text'),
    		tooltip : node.get('text')
    	});
    	this.addTab(contentPanel,module);
    	Ext.resumeLayouts(true); //恢复布局  		
    },
    
    addTab : function(content,module){
    	var tabs = content,
    	id = module.getItemId(),
    	tab = tabs.items.getByKey(id);
    	if(!tab){
    		tab = tabs.add(module);
    	}
    	tabs.setActiveTab(tab);
    },
    
    beforeHandleRout : function(id,action){
    	var me = this,
    		node = me.findNode(id);
    	if (node){
    		action.resume();
    	}else{
    		Ext.Msg.alert('系统错误','请求的模块 ' + id + '不能被找到，系统将定位到默认页面！',function(){
    			me.redirectTo(me.getApplication().getDefaultToken());
    		});
    	}//如果不合法就弹出提示，然后定位到系统的默认页面
    },   
	onMenuSelectForRout : function ( tree, record, index, eOpts ){
	    	this.redirectTo(record.get('moduleId'));   	   	
   },
	
    onMenuSelect : function ( tree, record, index, eOpts ){
    	var me = this,
    		contentPanel = me.getContentPanel(),
    		moduleId = record.get('moduleId');
    	var className = Ext.ClassManager.getNameByAlias('widget.'+moduleId);
    	var ViewClass = Ext.ClassManager.get(className);
    	var module = new ViewClass();
    	Ext.suspendLayouts(); //暂停布局
    	contentPanel.removeAll(true);
    	contentPanel.add(module); 
    	this.updateTitle(contentPanel,record);
    	Ext.resumeLayouts(true); //恢复布局    	   	
    },
	
	updateTitle : function(panel,node){
    	var title = node.get('text');
    	panel.setTitle(title);
    	document.title = title;
    }

});