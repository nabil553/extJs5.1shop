Ext.define('sa.view.main.Header', {
    extend: "Ext.toolbar.Toolbar",
    alias: 'widget.topheader',
    id: 'app-header',
    height: 52,
    initComponent :function(){
    	this.items = [{
    		id: 'app-header-logo',
    		xtype: 'component'
    	},{
    		id :'app-header-title',
    		xtype: 'component',
    		html:'沂品电子商务商城后台管理系统'
    	},'->',{
    		id:'app-exit',
    		text:'退出系统',
    		glyph:0xf011,
    		margin:'0 20 0 0',
    		handler:'onClickExit'
    	}];
    	this.callParent();
    }

});
