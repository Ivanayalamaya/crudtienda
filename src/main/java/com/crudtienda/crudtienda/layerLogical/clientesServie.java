package com.crudtienda.crudtienda.layerLogical;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudtienda.crudtienda.Entities.ClientesEntity;
import com.crudtienda.crudtienda.Repositories.clientesRepo;

@Service
public class clientesServie {

    @Autowired
    private  clientesRepo clientesrepo;

    //guarda un nuevo ciente
    public ClientesEntity save(ClientesEntity clientesEntity) {
        return clientesrepo.save(clientesEntity);
    }

    //etorna la lista de todos los clientes
    public List<ClientesEntity> listAll() {
        return clientesrepo.findAll();
    }


    //metodo que retornara una entidad de tipo cliente por su id
    public ClientesEntity get(int id) {
        ClientesEntity cliente =  clientesrepo.findById(id);
        if(cliente == null){
            throw new RuntimeException("Cliente no encontrado");
        }
        return cliente;
    }
    
    //metodo para saber si existe un cliente por su id
    public boolean existeCliente(int id){
        return clientesrepo.existsById(id);
    }

    //actualiza un cliente
    public boolean actualizacionCliente( ClientesEntity cliente) {
       ClientesEntity cleinteAActualizar = cliente;

       try{
              clientesrepo.save(cleinteAActualizar);
              return true;
       } catch (Exception e) {
           return false;
       }

    }
    
}
