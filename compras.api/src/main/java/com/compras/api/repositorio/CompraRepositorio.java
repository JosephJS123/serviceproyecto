package com.compras.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compras.api.entidad.Compra;

public interface CompraRepositorio extends JpaRepository<Compra, Long>{

}