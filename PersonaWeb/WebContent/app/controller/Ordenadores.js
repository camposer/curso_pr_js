Ext.define('PWeb.controller.Ordenadores', {
	extend: 'Ext.app.Controller',

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
            'editarordenador button[action=guardar]': {
                click: this.actualizarOrdenador
            }
		});
	},

	actualizarOrdenador: function(button) {
	    var win    = button.up('window'),
	        form   = win.down('form'),
	        record = form.getRecord(), 
	        values = form.getValues(); 

	    record.set(values); 
	    win.close();
	    
	    // synchronize the store after editing the record
	    this.getOrdenadoresStore().sync();

	},
	
	editarOrdenador: function(grid, record) {
		var view = Ext.widget('editarordenador');
console.log(record);
		view.down('form').loadRecord(record);
	}
});