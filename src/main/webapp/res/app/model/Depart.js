Ext.define('sa.model.Depart',{
	extend:'sa.model.Base',
	identifier:'uuid',
	fields:[{
		name:'id', type:'string'
	},{
		naem:'name', type:'string'
	},{
		name:'code', type:'string'
	},{
		name:'des', type:'string'
	}],
	proxy:{
		type:'ajax',
		api:{
			create:'/depart/new.do',
			read:'/depart/load.do',
			update:'/depart/update.do',
			destroy:'/depart/destroy.do'
		},
		//数据解析服务器
	reader:{
		rootProperty :'root',
		totalProperty:'total',
		successProperty:'success',
		messageProperty:'message'
		},
		//写入服务器的json
		writer:{
			type:'json',
			//转换
			transform:{
				fn:function(data,request){
					if(!Array.isArray(data)){
						var arrayData=new Array();
						arrayData.push(data);
						return arrayData;
					}
				},
				scope:this
			}
		}
	}
});