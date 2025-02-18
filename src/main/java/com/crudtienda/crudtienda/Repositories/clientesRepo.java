package com.crudtienda.crudtienda.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crudtienda.crudtienda.Entities.ClientesEntity;

@Repository
public interface clientesRepo extends JpaRepository<ClientesEntity, Integer> {
	
    List<ClientesEntity> findByNombreCliente(String nombreCliente);

    @Query("SELECT c FROM ClientesEntity c WHERE c.id = ?1")
    ClientesEntity findById(int id);
}
