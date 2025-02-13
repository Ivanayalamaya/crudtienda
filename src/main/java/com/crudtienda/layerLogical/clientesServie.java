package com.crudtienda.layerLogical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudtienda.crudtienda.Entities.ClientesEntity;
import com.crudtienda.crudtienda.Repositories.clientesRepo;

@Service
public class clientesServie {

    @Autowired
    private  clientesRepo clientesrepo;

    public void save(ClientesEntity clientesEntity) {
        clientesrepo.save(clientesEntity);
    }
    
}
