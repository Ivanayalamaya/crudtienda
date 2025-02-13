package com.crudtienda.crudtienda.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudtienda.crudtienda.Entities.ClientesEntity;

@Repository
public interface clientesRepo extends JpaRepository<ClientesEntity, Integer> {
	
    List<ClientesEntity> findByNombreCliente(String nombreCliente);
}
