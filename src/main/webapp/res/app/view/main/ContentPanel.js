Ext.define('sa.view.main.ContentPanel',{
    extend: 'Ext.tab.Panel',
    xtype : 'content-panel',
    id :'content-panel',
    requires:['Ext.ux.TabReorderer'],
    plugins:'tabreorderer'
});
