Ext.define('AM.view.user.List' ,{
    extend: 'Ext.grid.Panel',
    alias: 'widget.userlist', // Define el xtype del componente (en este caso userlist)

    title: 'All Users',

    store: 'Users',
	
    initComponent: function() {
    	/*// Ahora está definido arriba (Pedro regañó) 
        this.store = {
            fields: ['name', 'email'],
            data  : [
                {name: 'Ed',    email: 'ed@sencha.com'},
                {name: 'Tommy', email: 'tommy@sencha.com'}
            ]
        };
        */

        this.columns = [
            {header: 'Nombre',  dataIndex: 'name',  flex: 1},
            {header: 'Correo', dataIndex: 'email', flex: 1}
        ];

        this.callParent(arguments);
    }
});

