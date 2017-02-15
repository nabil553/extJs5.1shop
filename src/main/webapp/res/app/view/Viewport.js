Ext.define('sa.view.Viewport', {
    extend: 'Ext.container.Viewport',
    requires: ['sa.view.main.MainController','sa.view.left.LeftPanelModel','sa.view.main.Header','sa.view.left.LeftPanel','sa.view.main.ContentPanel'],
    layout: 'border',
    initComponent:function(){
    	Ext.setGlyphFontFamily('FontAwesome');
    	this.callParent();
    },
    items: [{
        region: 'north',
        xtype:'topheader'
    }, {
    	xtype:'leftpanel',
        region: 'west'
    }, {
        region: 'south',
        title: "<html><center>欢迎使用</center></html>",
        height: 40,
    }, {
    	id:'mainView',
        region: 'center',
        xtype: 'content-panel', // TabPanel itself has no title
        activeTab: 0,      // First tab active by default
        items: {
        title: '主操作区',
        html: '<iframe scrolling="no" frameborder="0" width="100%" height="100%" src="res/welcome.jsp"> </iframe>'
    }
}]
});
