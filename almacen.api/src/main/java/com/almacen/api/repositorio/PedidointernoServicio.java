package com.almacen.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.almacen.api.entidad.Pedidointerno;

public interface PedidointernoServicio extends JpaRepository<Pedidointerno, Long> {

}

