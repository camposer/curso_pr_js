Ext.define('PWeb.store.Ordenadores', {
    extend: 'Ext.data.Store',
    
    model: 'PWeb.model.Ordenador',
    
    autoLoad: true,

    data: [
        {id: 1, nombre: 'Ordenador#1', serial: '123456'},
        {id: 2, nombre: 'Ordenador#2', serial: '789012'}
    ]
});