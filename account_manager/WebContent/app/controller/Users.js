Ext.define('AM.controller.Users', {
	extend: 'Ext.app.Controller',

	views: [
	        'user.List',
	        'user.Edit'
	],
	
	stores: [ 'Users' ],
	
	models: [ 'User' ],

	init: function() {
		// Estos métodos son creados automáticamente por Ext siguiendo la convención de nombres
		// this.getUserListView();
		// this.getUserEditView();
		// this.getUsersStore();
		// this.getUserModel();
		
		this.control({
			'userlist': { // ComponentQuery
				itemdblclick: this.editUser
			},
            'useredit button[action=save]': {
                click: this.updateUser
            }
		});
	},

	updateUser: function(button) {
	    var win    = button.up('window'),
	        form   = win.down('form'),
	        record = form.getRecord(), // Los valores pasados originalmente (compartido con el GRID)
	        values = form.getValues(); // Los valores nuevos

	    record.set(values); // Actualizando el record con los valores nuevos
	    win.close();
	    
	    // synchronize the store after editing the record
	    this.getUsersStore().sync();

	},
	
	editUser: function(grid, record) {
		var view = Ext.widget('useredit');

		view.down('form').loadRecord(record);
	}
	
	/*
	editUser: function(grid, record) {
		console.log('Double clicked on ' + record.get('name'));
	}
        
    init: function() {
        this.control({ // Registro un escucha y su callback para el evento render sobre el componente especificado
            'viewport > panel': { // Asociando una acción a un elemento dado un Component Query
                render: this.onPanelRendered // Asocia un callback para un evento
            }
        });
    },
    
    onPanelRendered: function() {
        console.log('The panel was rendered');
    }
    
    init: function() {
        console.log('Initialized Users! This happens before the Application launch function is called');
    }
    */
});