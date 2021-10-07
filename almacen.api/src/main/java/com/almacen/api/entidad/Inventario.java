package com.almacen.api.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventario")
public class Inventario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idinventario;
	private String stockproductos;
	
	public Integer getIdinventario() {
		return idinventario;
	}
	public void setIdinventario(Integer idinventario) {
		this.idinventario = idinventario;
	}
	public String getStockproductos() {
		return stockproductos;
	}
	public void setStockproductos(String stockproductos) {
		this.stockproductos = stockproductos;
	}
	
	
}