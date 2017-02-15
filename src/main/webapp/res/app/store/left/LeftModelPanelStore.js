Ext.define('yzj.store.left.LeftModelPanelStore',{
	extend : 'Ext.data.Store',
	requires :["yzj.model.left.LeftModelMenu"],
	model:"yzj.model.left.LeftModelMenu",
	xtype : "leftModelPanelStore",
	autoLoad : false,
	proxy : {
		type : 'ajax',
		url : "system/web/home/getLeftPanelByTab",
		reader : {
			type : "json",
			rootProperty : "list"
		}
	}
});