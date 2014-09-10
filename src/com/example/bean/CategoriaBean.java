package com.example.bean;

import java.io.Serializable;

public class CategoriaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cat_id;
	private String cat_plataforma;
	private String cat_descripcion;
	private String cat_estado;
	
	public String getCat_id() {
		return cat_id;
	}
	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}
	public String getCat_plataforma() {
		return cat_plataforma;
	}
	public void setCat_plataforma(String cat_plataforma) {
		this.cat_plataforma = cat_plataforma;
	}
	public String getCat_descripcion() {
		return cat_descripcion;
	}
	public void setCat_descripcion(String cat_descripcion) {
		this.cat_descripcion = cat_descripcion;
	}
	public String getCat_estado() {
		return cat_estado;
	}
	public void setCat_estado(String cat_estado) {
		this.cat_estado = cat_estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
	
}
