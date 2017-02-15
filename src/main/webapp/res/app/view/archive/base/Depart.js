Ext.define('sa.view.archive.base.Depart',{
    extend: 'Ext.grid.Panel',
	xtype: 'depart-manage',
	requires:['Ext.toolbar.Paging','sa.view.archive.base.DepartController','sa.view.archive.base.DepartModel'],
	bind:'{departStore}',
	session:true,
	controller:'base-depart',
	viewModel:{
		type:'base-depart'
	},
	//默认添加按钮button
	tbar:[{
		text:'新增',
		tooltip:'这个tbar的提示',
		handler:'onNew'
	},{
		text:'批量删除',
		tooltip:'选择多个部门删除',
		handler:'onBatchDel'
	},'-',{
		text:'数据同步',
		tooltip:'同步所有改动到服务器',
	}],
	//底部分页工具条
	bbar:{
		reference:'departpagingtoolbar',
		bind:{store:'{departStore}'},
		xtype:'pagingtoolbar',
		displayInfo:true,
		displayMsg:'{0}-{1}of{2}',
		emgtyMsg:'无信息'
	},
	
	columns:[{
		text:'商品编号',width:'80', dataIndex:'code'
	},{
		text:'商品名称',width:'100', dataIndex:'name'
	},{
		text:'商品描述',width:'200', dataIndex:'des'
	},{
		xtype:'widgetcolumn',
		width:'90',
		widget:{
			xtype:'button',
			text:'修改',
			handler:'onEdit'
		}
	},{
			xtype:'widgetcolumn',
			width:'90',
			widget:{
				xtype:'button',
				text:'删除',
				handler:'onDel'
		}
	}],
	
	listeners:{
		afterlayout:{
			fn:'onAfterLayout',
			delay:1,
			single:true
		}
	}
});
