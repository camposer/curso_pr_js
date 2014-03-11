Ext.application({ 
    requires: ['Ext.container.Viewport'], 
    name: 'PWeb', 
    appFolder: 'app', 
    
    controllers: [ 'Ordenadores' ], 

    launch: function() { 
        Ext.create('Ext.container.Viewport', {
            layout: 'fit', 
            items: {
                xtype: 'listarordenadores'
            }
        });
    }
});