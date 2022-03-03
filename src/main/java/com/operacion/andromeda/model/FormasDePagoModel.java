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
@Table (name ="formas_de_pago")
public class FormasDePagoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column 
	private Integer id_forma_de_pago;
	
	@Column 
	private String tipo_tarjeta;
	
	@Column
	private long numero_tarjeta;
	
	@Column
	private int fecha_vencimiento;
	
	@Column
	private int cvv;
	
	@OneToMany(mappedBy = "formasDePagoModel",fetch = FetchType.LAZY)//UNO A MUCHOS
    private List<TicketsModel> ticketsModel;
	
	public FormasDePagoModel() {
		
	}

	public Integer getId_forma_de_pago() {
		return id_forma_de_pago;
	}

	public void setId_forma_de_pago(Integer id_forma_de_pago) {
		this.id_forma_de_pago = id_forma_de_pago;
	}

	public String getTipo_tarjeta() {
		return tipo_tarjeta;
	}

	public void setTipo_tarjeta(String tipo_tarjeta) {
		this.tipo_tarjeta = tipo_tarjeta;
	}

	public long getNumero_tarjeta() {
		return numero_tarjeta;
	}

	public void setNumero_tarjeta(long numero_tarjeta) {
		this.numero_tarjeta = numero_tarjeta;
	}

	public int getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(int fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public List<TicketsModel> getTicketsModel() {
		return ticketsModel;
	}

	public void setTicketsModel(List<TicketsModel> ticketsModel) {
		this.ticketsModel = ticketsModel;
	}

	@Override
	public String toString() {
		return "FormasDePagoModel [id_forma_de_pago=" + id_forma_de_pago + ", tipo_tarjeta=" + tipo_tarjeta
				+ ", numero_tarjeta=" + numero_tarjeta + ", fecha_vencimiento=" + fecha_vencimiento + ", cvv=" + cvv
				+ ", ticketsModel=" + ticketsModel + "]";
	}

}