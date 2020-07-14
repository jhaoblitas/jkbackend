package com.pais.bean;

public class AuthUsuario {
	
	private long idCodigo;
	private String cidUsuario;
	private String cidClave;
	private String cidNombre;
	private String puesto;
	
	public long getIdCodigo() {
		return idCodigo;
	}
	public void setIdCodigo(long idCodigo) {
		this.idCodigo = idCodigo;
	}
	public String getCidUsuario() {
		return cidUsuario;
	}
	public void setCidUsuario(String cidUsuario) {
		this.cidUsuario = cidUsuario;
	}
	public String getCidClave() {
		return cidClave;
	}
	public void setCidClave(String cidClave) {
		this.cidClave = cidClave;
	}
	public String getCidNombre() {
		return cidNombre;
	}
	public void setCidNombre(String cidNombre) {
		this.cidNombre = cidNombre;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
}
