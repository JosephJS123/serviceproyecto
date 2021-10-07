package com.almacen.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almacen.api.entidad.Movimiento;

public interface MovimientoServicio extends JpaRepository<Movimiento, Long>{

}