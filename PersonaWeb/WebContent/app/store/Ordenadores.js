Ext.define('PWeb.store.Ordenadores', {
    extend: 'Ext.data.Store',
    
    model: 'PWeb.model.Ordenador',
    
    autoLoad: true,

    proxy: {
    	url: '/PersonaWeb/rest/ordenadores',
    	type: 'rest',
        reader: {
            type: 'json',
            root: 'data'
        }
    }
});