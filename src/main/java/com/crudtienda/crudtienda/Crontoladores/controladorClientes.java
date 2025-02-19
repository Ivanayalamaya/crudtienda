package com.crudtienda.crudtienda.Crontoladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crudtienda.crudtienda.layerLogical.clientesServie;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.crudtienda.crudtienda.Advice.messageError;
import com.crudtienda.crudtienda.Entities.ClientesEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/clientes")
public class controladorClientes {

    private clientesServie clientesServie;

    @Autowired
    public controladorClientes(clientesServie clientesServie) {
         this.clientesServie = clientesServie;
     }

    @GetMapping("/clientes")
    public String getMethodName() {
        String holamundo = "hola mundo";
        return holamundo;
    }
    

    @PostMapping("/newCliente")
    public ResponseEntity<messageError> postMethodName(@RequestBody ClientesEntity cliente) {
        //TODO: process POST request
        clientesServie.save(cliente);
        messageError message = new messageError("Cliente guardado", 200);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ClientesEntity getClientebyID(@PathVariable int id){

        return clientesServie.get(id);
    }

}
