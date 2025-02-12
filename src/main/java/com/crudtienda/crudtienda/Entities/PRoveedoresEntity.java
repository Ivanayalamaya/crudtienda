package com.crudtienda.crudtienda.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedores", schema = "public")
public class PRoveedoresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProveedor;
    private String nombreProveedor;
    private String giroProveedor;
    private String direccionProveedor;
    private String telefonoProveedor;
    private String emailProveedor;
    public int getIdProveedor() {
        return idProveedor;
    }
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    public String getNombreProveedor() {
        return nombreProveedor;
    }
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
    public String getGiroProveedor() {
        return giroProveedor;
    }
    public void setGiroProveedor(String giroProveedor) {
        this.giroProveedor = giroProveedor;
    }
    public String getDireccionProveedor() {
        return direccionProveedor;
    }
    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }
    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }
    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }
    public String getEmailProveedor() {
        return emailProveedor;
    }
    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }
    
    
}
