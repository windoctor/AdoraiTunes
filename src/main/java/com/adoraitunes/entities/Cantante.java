package com.adoraitunes.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Cantante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3841365567493549605L;
	private String nombre;
	private String biografia;
	private Date fechaNacimiento;
	
	private List<Album> albums;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	
	
	
}
