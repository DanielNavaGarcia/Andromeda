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
@Table(name = "direcciones")
public class DireccionesModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id_direccion;
	
	@Column
	private String estado;
	
	@Column 
	private String ciudad;
	
	@Column 
	private String direccion;
	
	@Column 
	private int codigo_postal;
	
	@Column 
	private String numero_interior;
	
	@Column 
	private String numero_exterior;
	
	@Column 
	private String informacion_adicional;
	
	@Column 
	private String nombre_destinatario;
	
	@Column 
	private String apellido_destinatario;
	
	@Column 
	private String email_destinatario;
	
	@OneToMany(mappedBy = "direccionesModel",fetch = FetchType.LAZY)//UNO A MUCHOS
    private List<TicketsModel> ticketsModel;
	
	public DireccionesModel() {
		
	}

	public Integer getId_direccion() {
		return id_direccion;
	}

	public void setId_direccion(Integer id_direccion) {
		this.id_direccion = id_direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(int codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public String getNumero_interior() {
		return numero_interior;
	}

	public void setNumero_interior(String numero_interior) {
		this.numero_interior = numero_interior;
	}

	public String getNumero_exterior() {
		return numero_exterior;
	}

	public void setNumero_exterior(String numero_exterior) {
		this.numero_exterior = numero_exterior;
	}

	public String getInformacion_adicional() {
		return informacion_adicional;
	}

	public void setInformacion_adicional(String informacion_adicional) {
		this.informacion_adicional = informacion_adicional;
	}

	public String getNombre_destinatario() {
		return nombre_destinatario;
	}

	public void setNombre_destinatario(String nombre_destinatario) {
		this.nombre_destinatario = nombre_destinatario;
	}

	public String getApellido_destinatario() {
		return apellido_destinatario;
	}

	public void setApellido_destinatario(String apellido_destinatario) {
		this.apellido_destinatario = apellido_destinatario;
	}

	public String getEmail_destinatario() {
		return email_destinatario;
	}

	public void setEmail_destinatario(String email_destinatario) {
		this.email_destinatario = email_destinatario;
	}

	
	
	public List<TicketsModel> getTicketsModel() {
		return ticketsModel;
	}

	public void setTicketsModel(List<TicketsModel> ticketsModel) {
		this.ticketsModel = ticketsModel;
	}

	@Override
	public String toString() {
		return "DireccionesModel [id_direccion=" + id_direccion + ", estado=" + estado + ", ciudad=" + ciudad
				+ ", direccion=" + direccion + ", codigo_postal=" + codigo_postal + ", numero_interior="
				+ numero_interior + ", numero_exterior=" + numero_exterior + ", informacion_adicional="
				+ informacion_adicional + ", nombre_destinatario=" + nombre_destinatario + ", apellido_destinatario="
				+ apellido_destinatario + ", email_destinatario=" + email_destinatario + ", ticketsModel="
				+ ticketsModel + "]";
	}
}
