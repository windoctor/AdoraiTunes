package com.adoraitunes.entities;

import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Date;
import java.util.DoubleSummaryStatistics;

public class Cancion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5583277772346155855L;
    public static final String CATOLICA = "CATOLICA";
    public static final String EVANGELICA = "EVANGELICA";

    private ObjectId _id;

	private String nombre;
	private String cantante;
	private String link;
	private String portada;
    private String inspiracion;
    private Boolean inicio;
    private Date fecha;
    private Double plays;
    private Double likes;
    private Integer prioridad;

    public Cancion() {
    }

    public ObjectId get_id() {
        return _id;
    }

    public Cancion(String nombre, String cantante, String link, String portada) {
        this.nombre = nombre;
        this.cantante = cantante;
        this.link = link;
        this.portada = portada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public Boolean getInicio() {
        return inicio;
    }

    public void setInicio(Boolean inicio) {
        this.inicio = inicio;
    }

    public String getInspiracion() {
        return inspiracion;
    }

    public void setInspiracion(String inspiracion) {
        this.inspiracion = inspiracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getPlays() {
        return plays;
    }

    public void setPlays(Double plays) {
        this.plays = plays;
    }

    public Double getLikes() {
        return likes;
    }

    public void setLikes(Double likes) {
        this.likes = likes;
    }

    public Long getRating(){
        double r = likes/plays;
        return Math.round(r*5);
    }

    public Long getRating2(){
        return 5 - getRating();
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "_id=" + _id +
                ", nombre='" + nombre + '\'' +
                ", cantante='" + cantante + '\'' +
                ", link='" + link + '\'' +
                ", portada='" + portada + '\'' +
                ", inspiracion='" + inspiracion + '\'' +
                ", inicio=" + inicio +
                ", fecha=" + fecha +
                ", plays=" + plays +
                ", likes=" + likes +
                ", prioridad=" + prioridad +
                '}';
    }
}
