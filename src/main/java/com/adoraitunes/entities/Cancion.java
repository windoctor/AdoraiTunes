package com.adoraitunes.entities;

import com.adoraitunes.enums.Inspiracion;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Date;

public class Cancion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5583277772346155855L;

    private ObjectId _id;

	private String nombre;
	private String cantante;
    private String album;
	private String link;
	private String portada;
    private Inspiracion inspiracion;
    private String[] playlist;
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
        this.nombre = StringUtils.upperCase(nombre);
        this.cantante = StringUtils.upperCase(cantante);
        this.link = link;
        this.portada = portada;
    }

    public Cancion(String nombre, Inspiracion inspiracion) {
        this.nombre = StringUtils.upperCase(nombre);
        this.inspiracion = inspiracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = StringUtils.upperCase(nombre);
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = StringUtils.upperCase(cantante);
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

    public Inspiracion getInspiracion() {
        return inspiracion;
    }

    public void setInspiracion(Inspiracion inspiracion) {
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

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public String[] getPlaylist() {
        return playlist;
    }

    public void setPlaylist(String[] playlist) {
        this.playlist = playlist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = StringUtils.upperCase(album);
    }

    public Integer getRank(){
        return new BigDecimal(likes / plays)
                .multiply(new BigDecimal(5))
                .setScale(0, RoundingMode.DOWN).intValue();
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
                ", fecha=" + fecha +
                ", plays=" + plays +
                ", likes=" + likes +
                ", prioridad=" + prioridad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cancion cancion = (Cancion) o;

        if (_id != null ? !_id.equals(cancion._id) : cancion._id != null) return false;
        if (nombre != null ? !nombre.equals(cancion.nombre) : cancion.nombre != null) return false;
        return !(inspiracion != null ? !inspiracion.equals(cancion.inspiracion) : cancion.inspiracion != null);

    }

    @Override
    public int hashCode() {
        int result = _id != null ? _id.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (inspiracion != null ? inspiracion.hashCode() : 0);
        return result;
    }
}
