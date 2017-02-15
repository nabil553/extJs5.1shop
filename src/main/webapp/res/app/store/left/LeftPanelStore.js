Ext.define('sa.store.left.LeftPanelStore',{
	extend : 'Ext.data.Store',
	requires :['sa.model.left.LeftPanel'],
	model:'sa.model.left.LeftPanel',
	autoLoad : true,
	proxy : {
		type : 'ajax',
		url : 'home/getLeftPanel',
		reader : {
			type : 'json',
			rootProperty : 'list'
		}
	}
});