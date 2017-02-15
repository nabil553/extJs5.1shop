Ext.define('sa.model.left.LeftTreePanelNode',{
	extend : 'Ext.data.Model',
	fields: [
         {name: "id", type: "string"},
         {name: "parentid", type: "string"},
	     {name: "text", type: "string"},
	     {name: "url", type: "string"},
	     {name: "childCount", type: "int"},
	     {name: "leaf", type: "boolean"}
    ]
});