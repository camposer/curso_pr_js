Ext.define('PWeb.view.ordenador.Listar' ,{
    extend: 'Ext.grid.Panel',
    alias: 'widget.listarordenadores', 

    title: 'Ordenadores',

    store: 'Ordenadores',
	
    initComponent: function() {
        this.columns = [
            {header: 'Id',  dataIndex: 'id',  flex: 1},
            {header: 'Nombre',  dataIndex: 'nombre',  flex: 1},
            {header: 'Serial', dataIndex: 'serial', flex: 1}
        ];

        this.callParent(arguments);
    }
});