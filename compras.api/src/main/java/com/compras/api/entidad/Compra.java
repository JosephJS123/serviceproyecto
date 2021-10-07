package com.compras.api.entidad;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="compra")
public class Compra implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long idcompra;
	private String fecha;
	private String observaciones;
	private Double total;
	
	@ManyToOne
	@JoinColumn(name = "idproveedor")
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name = "iddetallecompra")
	private Detallecompra detallecompra;

	public Long getIdcompra() {
		return idcompra;
	}

	public void setIdcompra(Long idcompra) {
		this.idcompra = idcompra;
	}

	public String getHoraActual() {
	    Date ahora = new Date();
	    SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
	    return formateador.format(ahora);
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Double getTotalcompra() {
		double totalcompra = 0.0;
		totalcompra += detallecompra.getSubtotal();
		
		return totalcompra;
	}
	
	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Detallecompra getDetallecompra() {
		return detallecompra;
	}

	public void setDetallecompra(Detallecompra detallecompra) {
		this.detallecompra = detallecompra;
	}
	
}