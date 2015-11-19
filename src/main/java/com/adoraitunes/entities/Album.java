package com.adoraitunes.entities;

import java.io.Serializable;
import java.util.List;

public class Album implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -66302644194541486L;
	private String nombre;
	private String caratula;
	private List<Cancion> canciones; 
	
	private Cantante cantante;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCaratula() {
		return caratula;
	}

	public void setCaratula(String caratula) {
		this.caratula = caratula;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

	public Cantante getCantante() {
		return cantante;
	}

	public void setCantante(Cantante cantante) {
		this.cantante = cantante;
	}
}
