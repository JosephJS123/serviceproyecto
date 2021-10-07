package com.almacen.api.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="movimientos")
public class Movimiento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idmovimientos;
	private String tipomovimiento;
	
	@ManyToOne
	@JoinColumn(name = "idempleado")
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name = "idalmacen")
	private Almacen almacen;
	
	@ManyToOne
	@JoinColumn(name = "idkardex")
	private Kardex kardex;
	
	@ManyToOne
	@JoinColumn(name = "idpedidointerno")
	private Pedidointerno pedidointerno;
	
	@ManyToOne
	@JoinColumn(name = "idinventario")
	private Inventario inventario;

	public Integer getIdmovimientos() {
		return idmovimientos;
	}

	public void setIdmovimientos(Integer idmovimientos) {
		this.idmovimientos = idmovimientos;
	}

	public String getTipomovimiento() {
		return tipomovimiento;
	}

	public void setTipomovimiento(String tipomovimiento) {
		this.tipomovimiento = tipomovimiento;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public Kardex getKardex() {
		return kardex;
	}

	public void setKardex(Kardex kardex) {
		this.kardex = kardex;
	}

	public Pedidointerno getPedidointerno() {
		return pedidointerno;
	}

	public void setPedidointerno(Pedidointerno pedidointerno) {
		this.pedidointerno = pedidointerno;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

    
}

