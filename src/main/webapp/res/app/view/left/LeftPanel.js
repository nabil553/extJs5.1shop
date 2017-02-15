Ext.define('sa.view.left.LeftPanel',{
	extend:'Ext.panel.Panel',
	requires : ['sa.view.left.LeftPanelController', 'sa.view.left.LeftModelPanel',  'sa.model.left.LeftPanel', 'sa.store.left.LeftPanelStore'],
	alias:'widget.leftpanel',
	controllers : 'leftPanel',
	title:'系统菜单',
	glyph:0xf0c9,
	frame:true,
	collapsible:true,
	width:240,
	split:true,
	viewModel:'left',
	layout:{
		type:'accordion',
		animate:true
	},
	requires : ['Ext.tree.Panel'],
	initComponent:function(){
    	var me = this;
    	me.items = [];
    	var menus = me.getViewModel().get('leftMenu.menuGroup');
    	function makeTreeStore(group){
    		var storeTree = Ext.create('Ext.data.TreeStore',{
    			root:{
    				text: group.text,
                	expanded: true,
                	leaf: false
    			}
    		});
    		var root = storeTree.getRootNode();
    		var menuItems = group.menuItems;
    		for (var i in menuItems){
    			var item = menuItems[i];
    			var childNode = Ext.apply({},{
    				text : item.text,
    				leaf : true,
    				glyph : item.glyph,
    				id : item.module,
    				moduleId : item.module,
    				moduleName : item.text
    				
    			});
    			root.appendChild(childNode);
    		}
    		return storeTree;
    	}
    	for (var i in menus){
    		var menuGroup = menus[i];
    		var groupPanel = Ext.create('Ext.tree.TreePanel',{
    			title : menuGroup.text,
    			rootVisible : false,
    			store: makeTreeStore(menuGroup)
    			//listeners:{
    				//捕获到选择菜单项
    				//select:'onMenuItemSelect'
    			//}
    		});
    		me.items.push(groupPanel);
    	}
    	this.callParent();
    }
    
});
