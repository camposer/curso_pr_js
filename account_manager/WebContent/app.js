Ext.application({ // Define la aplicación
    requires: ['Ext.container.Viewport'], // Import de la clase que define el área donde se dibuja la vista
    name: 'AM', // Nombre de la app (espacio de nombres)
    appFolder: 'app', // Directorio con el código JS
    
    controllers: [ 'Users' ], // Registrando controllers

    launch: function() { // Método prinicipal (main)
        Ext.create('Ext.container.Viewport', {
            layout: 'fit', // Abarca toda el área
            items: {
                xtype: 'userlist'
            }
        });
    }
});