Ext.define('PWeb.view.ordenador.Editar', {
    extend: 'Ext.window.Window',
    alias: 'widget.editarordenador',

    title: 'Ordenador',
    layout: 'fit',
    autoShow: true,

    initComponent: function() {
        this.items = [
            {
                xtype: 'form', 
                items: [
                    {
                        xtype: 'textfield',
                        name : 'nombre',
                        fieldLabel: 'Nombre'
                    },
                    {
                        xtype: 'textfield',
                        name : 'serial',
                        fieldLabel: 'Serial'
                    }
                ]
            }
        ];

        this.buttons = [
            {
                text: 'Guardar',
                action: 'guardar'
            },
            {
                text: 'Cancelar',
                scope: this,
                handler: this.close
            }
        ];

        this.callParent(arguments);
    }
});