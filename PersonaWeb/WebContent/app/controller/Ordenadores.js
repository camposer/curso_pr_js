Ext.define('PWeb.controller.Ordenadores', {
	extend: 'Ext.app.Controller',

	accion: null,
	
	views: [
	        'ordenador.Listar',
	        'ordenador.Editar'
	],
	
	stores: [ 'Ordenadores' ],
	
	models: [ 'Ordenador' ],

	init: function() {
		this.control({
			'listarordenadores': { 
				itemdblclick: this.editarOrdenador
			},
			'listarordenadores button[action=agregar]': { 
				click: this.agregarOrdenador
			},
			'listarordenadores button[action=eliminar]': { 
				click: this.eliminarOrdenador
			},
            'editarordenador button[action=guardar]': {
                click: this.actualizarOrdenador
            }
		});
	},

	eliminarOrdenador: function(button) {
        var lista = button.up('listarordenadores');
        var record = lista.getSelectionModel().getSelection();
        var store = this.getOrdenadoresStore();

        store.remove(record);
        store.sync(); // Actualiza el store contra la API Rest
	},
	
	actualizarOrdenador: function(button) {
	    var win    = button.up('window'),
	        form   = win.down('form'),
	        record = form.getRecord(), 
	        values = form.getValues(),
	        store = this.getOrdenadoresStore();

	    if (this.accion == 'agregar') { // Agrega al store
	    	// FIXME: PersonaId a capón
	    	
	    	var o = Ext.create('PWeb.model.Ordenador', {
	    		nombre: values.nombre,
	    		serial: values.serial,
	    		persona: {
	    			id: 13
	    		}
	    	});
	    	
	    	store.add(o);
	    } else if (this.accion = 'modificar') { // Modifica el store
		    record.set(values); 	
	    }
	    
	    win.close();
	    store.sync();
	    store.load(); // Para que cargue los datos recién agregados 
	},
	
	agregarOrdenador: function(grid, record) {
		var view = Ext.widget('editarordenador');
		this.accion = 'agregar';
	},

	editarOrdenador: function(grid, record) {
		var view = Ext.widget('editarordenador');
		view.down('form').loadRecord(record);
		this.accion = 'modificar';
	}
});