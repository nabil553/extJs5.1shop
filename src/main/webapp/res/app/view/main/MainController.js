Ext.define('sa.view.main.MainController', {
    extend: 'Ext.app.ViewController',
    requires:['sa.view.archive.base.Menu','sa.view.archive.base.Depart'],
    alias: 'controller.main',
    onClickExit:function () {
		Ext.Msg.confirm('系统提醒','确定要退出系统吗？','onExitConfirm',this);
    },
    onExitConfirm: function (choice) {
        if (choice === 'yes') {
			Ext.Msg.alert('信息','已经确定退出！');
        }
    }
});
