package com.compras.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compras.api.entidad.Proveedor;

public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long>{

}