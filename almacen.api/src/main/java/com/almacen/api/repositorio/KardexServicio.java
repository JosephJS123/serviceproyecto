package com.almacen.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almacen.api.entidad.Kardex;

public interface KardexServicio extends JpaRepository<Kardex, Long> {

}