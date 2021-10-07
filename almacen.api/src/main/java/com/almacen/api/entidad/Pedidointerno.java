package com.almacen.api.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pedidointerno")
public class Pedidointerno implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idpedidointerno;
	private String fecha;
	private Integer cantidad;
	
	public Integer getIdpedidointerno() {
		return idpedidointerno;
	}
	public void setIdpedidointerno(Integer idpedidointerno) {
		this.idpedidointerno = idpedidointerno;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}