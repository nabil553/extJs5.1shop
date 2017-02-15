Ext.define('sa.view.left.LeftPanelModel',{
	extend:'Ext.app.ViewModel',
	alias:'viewmodel.left',
		   data: {
			   systemInfo:{
				  appName:'沂品电子商务后台信息管理系统' 
			   },
		        leftMenu : {
		        	menuGroup : [{
		        		text:'商品管理',
		        		glyph:0xf0c9,
		        		menuItems:[{
		        			text :'新增商品管理',
		        			glyph:0xf082,
		        			module : 'menu-manage'
		        		},{
		        			text:'查询商品管理',
		        			glyph:0xf108,
		        			module : 'depart-manage'
		        		}]
		        	},{
		        		text :'订单管理',
		        		glyph:0xf0c9,
		        		menuItems:[{
		        			text:'确认订单/押金管理',
		        			glyph:0xf082,
		        			module : 'dingdan-manage'
		        		},{
		        			text:'已上/未上菜单管理',
		        			glyph:0xf082,
		        			module : 'caidan-manage'
		        		},{
		        			text:'寄存菜单管理',
		        			glyph:0xf082,
		        			module : 'jicun-manage'
		        		}]
		        	},{
		        		text :'外卖订单管理',
		        		glyph:0xf0c9,
		        		description :'',
		        		menuItems:[{
		        			text:'开启/关闭外卖功能',
		        			glyph:0xf082,
		        			module : 'start-manage'
		        		},{
		        			text:'接单/配送管理',
		        			glyph:0xf082,
		        			module : 'jiedan-manage'
		        		},{
		        			text:'支付管理',
		        			glyph:0xf082,
		        			module : 'zhifu-manage'
		        		},{
		        			text:'订单完成/评价管理',
		        			glyph:0xf088,
		        			module :'dingdan-manage'
		        		}]
		        	},{
		        		text : '会员信息管理',
		        		glyph : 0xf0c9,
		        		description:'',
		        		menuItems:[{
		        			text:'会员个人信息管理',
		        			glyph:0xf099,
		        			module:'hyinfo-manage'
		        		},{
		        			text:'会员积分/优惠券管理',
		        			glyph:0xf065,
		        			module:'hyjifen-manage'
		        		},{
		        			text:'会员订单明细管理',
		        			glyph:0xf078,
		        			module:'hymingxi-manage'
		        		}]
		        	},{
		        		text:'统计查询管理',
		        		glyph : 0xf0c9,
		        		description:'',
		        		menuItems:[{
		        			text:'订单查询管理',
		        			glyph:0xf065,
		        			module:'didanchaxun-manage'
		        		},{
		        			text:'客流量统计分析',
		        			glyph:0xf064
		        		}]
		        	},{
		        		text:'商户管理'
		        	},{
		        		text :'会员管理'
		        	},{
		        		text:'角色权限管理'
		        	},{
		        		text:'第三方软件管理'
		        	}]
		        }
		        //具体的功能模块项
		    }

		});