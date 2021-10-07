package com.almacen.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almacen.api.entidad.Empleado;

public interface EmpleadoServicio extends JpaRepository<Empleado, Long>{

}

