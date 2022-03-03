package com.operacion.andromeda.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuariosModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id_usuario;
	
	@Column
	private String nombre_cliente ;
	
	@Column
	private String apellido_cliente ;
	
	@Column
	private String correo;
	
	@Column
	private String contrasenia;
	
	@OneToMany(mappedBy = "usuariosModel",fetch = FetchType.LAZY)//UNO A MUCHOS
    private List<TicketsModel> ticketsModel;
	
	public UsuariosModel() {
		
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getApellido_cliente() {
		return apellido_cliente;
	}

	public void setApellido_cliente(String apellido_cliente) {
		this.apellido_cliente = apellido_cliente;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}



	public List<TicketsModel> getTicketsModel() {
		return ticketsModel;
	}

	public void setTicketsModel(List<TicketsModel> ticketsModel) {
		this.ticketsModel = ticketsModel;
	}

	@Override
	public String toString() {
		return "UsuariosModel [id_usuario=" + id_usuario + ", nombre_cliente=" + nombre_cliente + ", apellido_cliente="
				+ apellido_cliente + ", correo=" + correo + ", contrasenia=" + contrasenia + ", ticketsModel="
				+ ticketsModel + "]";
	}
}	
