package com.compras.api.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long idproveedor;
	private String persona;
	private String razon;
	private String telefono;
	public Long getIdproveedor() {
		return idproveedor;
	}
	public void setIdproveedor(Long idproveedor) {
		this.idproveedor = idproveedor;
	}
	public String getPersona() {
		return persona;
	}
	public void setPersona(String persona) {
		this.persona = persona;
	}
	public String getRazon() {
		return razon;
	}
	public void setRazon(String razon) {
		this.razon = razon;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	

}