package com.compras.api.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detallecompra")
public class Detallecompra implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long iddetallecompra;
	private Integer cantidad;
	private Double subtotal;
	
	@ManyToOne
	@JoinColumn(name = "idproducto")
	private Producto producto;

	public Long getIddetallecompra() {
		return iddetallecompra;
	}

	public void setIddetallecompra(Long iddetallecompra) {
		this.iddetallecompra = iddetallecompra;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	

	

	
	
}