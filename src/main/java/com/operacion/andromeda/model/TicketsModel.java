package com.operacion.andromeda.model;

import java.util.HashSet;
import java.util.Set;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "tickets")
public class TicketsModel { //implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id_ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = Access.WRITE_ONLY)
    @JoinColumn(name = "id_usuario")
    private UsuariosModel usuariosModel;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = Access.WRITE_ONLY)
    @JoinColumn(name = "id_direccion")
    private DireccionesModel direccionesModel;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = Access.WRITE_ONLY)
    @JoinColumn(name = "id_envio")
    private MetodosDeEnvioModel metodosDeEnvioModel;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = Access.WRITE_ONLY)
    @JoinColumn(name = "id_forma_de_pago")
    private FormasDePagoModel formasDePagoModel;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonProperty(access = Access.WRITE_ONLY)
    @JoinTable(
    		name = "tickets_productos",
            joinColumns = {
                    @JoinColumn(name = "id_ticket", referencedColumnName = "id_ticket",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto",
                            nullable = false, updatable = false)})
    private Set<ProductosModel> productosModel = new HashSet<>();
    
	@Column
	private String estatus_del_pedido;
	
	@Column
	private LocalDateTime fecha;
	
	public TicketsModel() {

	}

	public Integer getId_ticket() {
		return id_ticket;
	}

	public void setId_ticket(Integer id_ticket) {
		this.id_ticket = id_ticket;
	}

	public UsuariosModel getUsuariosModel() {
		return usuariosModel;
	}

	public void setUsuariosModel(UsuariosModel usuariosModel) {
		this.usuariosModel = usuariosModel;
	}

	public DireccionesModel getDireccionesModel() {
		return direccionesModel;
	}

	public void setDireccionesModel(DireccionesModel direccionesModel) {
		this.direccionesModel = direccionesModel;
	}

	public MetodosDeEnvioModel getMetodosDeEnvioModel() {
		return metodosDeEnvioModel;
	}

	public void setMetodosDeEnvioModel(MetodosDeEnvioModel metodosDeEnvioModel) {
		this.metodosDeEnvioModel = metodosDeEnvioModel;
	}

	public FormasDePagoModel getFormasDePagoModel() {
		return formasDePagoModel;
	}

	public void setFormasDePagoModel(FormasDePagoModel formasDePagoModel) {
		this.formasDePagoModel = formasDePagoModel;
	}

	public Set<ProductosModel> getProductosModel() {
		return productosModel;
	}

	public void setProductosModel(Set<ProductosModel> productosModel) {
		this.productosModel = productosModel;
	}

	public String getEstatus_del_pedido() {
		return estatus_del_pedido;
	}

	public void setEstatus_del_pedido(String estatus_del_pedido) {
		this.estatus_del_pedido = estatus_del_pedido;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "TicketsModel [id_ticket=" + id_ticket + ", usuariosModel=" + usuariosModel + ", direccionesModel="
				+ direccionesModel + ", metodosDeEnvioModel=" + metodosDeEnvioModel + ", formasDePagoModel="
				+ formasDePagoModel + ", productosModel=" + productosModel + ", estatus_del_pedido="
				+ estatus_del_pedido + ", fecha=" + fecha + "]";
	}

}
