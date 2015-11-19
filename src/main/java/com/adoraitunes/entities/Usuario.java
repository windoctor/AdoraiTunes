package com.adoraitunes.entities;

import com.adoraitunes.enums.Generos;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.jongo.marshall.jackson.oid.MongoObjectId;

import java.util.Arrays;
import java.util.Date;

public class Usuario {

	private String _id;

	private String nombre;
	private String apellidos;
	private String email;
	private String foto;
	private Generos sexo;
	private Date fechaNacimiento;
	private String username;
	private String password;
	private String salt;
	private String[] songlikes;

    public Usuario() {

    }

	public Usuario(String username) {
		this.username = username;
	}

	public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Generos getSexo() {
        return sexo;
    }

    public void setSexo(Generos sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String[] getSonglikes() {
		return songlikes;
	}

	public void setSonglikes(String[] songlikes) {
		this.songlikes = songlikes;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"_id='" + _id + '\'' +
				", nombre='" + nombre + '\'' +
				", apellidos='" + apellidos + '\'' +
				", email='" + email + '\'' +
				", foto='" + foto + '\'' +
				", sexo=" + sexo +
				", fechaNacimiento=" + fechaNacimiento +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", salt='" + salt + '\'' +
				", songlikes=" + Arrays.toString(songlikes) +
				'}';
	}
}
