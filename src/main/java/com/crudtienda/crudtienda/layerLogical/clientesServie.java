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

    //metodo que se serciora de que no haya un cliente con el mismo nombre y apellido
    public void existeCliente(String nombreCliente, String apellidoCliente) {
        ClientesEntity existecliente =clientesrepo.existeCliente(nombreCliente, apellidoCliente);
        if (existecliente == null) {
            return;
        }
        if(  existecliente.getId_cliente()!=0 ){
            throw new RuntimeException("El cliente "+ nombreCliente+" " + apellidoCliente + "  ya existe");
        }
        
    }

    public void yaEstaAsociadoEmail(String email) {
        ClientesEntity yaExisteEmail = clientesrepo.yaEstaAsociadoEmail(email);
        if(yaExisteEmail != null){
            throw new RuntimeException("El email " + email + " esta asociado a otro cliente, por favor ingrese otro email");

        }
        
        
    }

    //metodo que retornara una entidad de tipo cliente por su id
    public ClientesEntity get(int id) {
        ClientesEntity cliente =  clientesrepo.findById(id);
        if(cliente == null){
            throw new RuntimeException("Cliente con id "+ id+ " no encontrado");
        }
        return cliente;
    }
    
    //metodo para saber si existe un cliente por su id
    public boolean existeCliente(int id){
        return clientesrepo.existsById(id);
    }

    //actualiza un cliente
    public boolean actualizacionCliente( ClientesEntity cliente) {
       
       ClientesEntity clienteEncontrado = clientesrepo.findById(cliente.getId_cliente());
       if(cliente.getNombreCliente()!=null){
           clienteEncontrado.setNombreCliente(cliente.getNombreCliente());
       }
       if(cliente.getApellidoCliente()!=null){
           clienteEncontrado.setApellidoCliente(cliente.getApellidoCliente());
       }
       if(cliente.getDireccionCliente()!=null){
           clienteEncontrado.setDireccionCliente(cliente.getDireccionCliente());
       }
         if(cliente.getTelefonoCliente()!=null){
              clienteEncontrado.setTelefonoCliente(cliente.getTelefonoCliente());
         }
        if(cliente.getEmailCliente()!=null){
                clienteEncontrado.setEmailCliente(cliente.getEmailCliente());
            }         

       try{
              clientesrepo.save(clienteEncontrado);
              return true;
       } catch (Exception e) {
           return false;
       }

    }
    
}
