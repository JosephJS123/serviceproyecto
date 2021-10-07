package com.compras.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compras.api.entidad.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Long>{

}