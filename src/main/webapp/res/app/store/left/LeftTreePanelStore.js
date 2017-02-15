Ext.define('sa.store.left.LeftTreePanelStore',{
	extend : 'Ext.data.TreeStore',
	requires :["sa.model.left.LeftTreePanelNode"],
	model:"sa.model.left.LeftTreePanelNode",
	autoLoad : true,
	proxy : {
		type : 'ajax',
		url : "home/getLeftPanelTree",
		reader : {
			type : "json",
			rootProperty : "nodeList"
		}
	},
	rootVisible:false
});