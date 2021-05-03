package co.edu.usbcali.viajes.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import co.edu.usbcali.viajes.app.domain.Destino;
import co.edu.usbcali.viajes.app.domain.Plan;

public class DetallePlanDTO {

	
	private Integer idDepl;
	private String alimentacion;
	private String hospedaje;
	private String transporte;
	private String traslados;
	private Integer valor;
	private Integer cantidadNoches;
	private Integer cantidadDias;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String usuCreador;
	private String usuModificador;
	private String estado;
	private Integer idPlan;
	private Integer idDest;
	
	
	public DetallePlanDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DetallePlanDTO(Integer idDepl, String alimentacion, String hospedaje, String transporte, String traslados,
			Integer valor, Integer cantidadNoches, Integer cantidadDias, Date fechaCreacion, Date fechaModificacion,
			String usuCreador, String usuModificador, String estado, Integer idPlan, Integer idDest) {
		super();
		this.idDepl = idDepl;
		this.alimentacion = alimentacion;
		this.hospedaje = hospedaje;
		this.transporte = transporte;
		this.traslados = traslados;
		this.valor = valor;
		this.cantidadNoches = cantidadNoches;
		this.cantidadDias = cantidadDias;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuCreador = usuCreador;
		this.usuModificador = usuModificador;
		this.estado = estado;
		this.idPlan = idPlan;
		this.idDest = idDest;
	}


	public Integer getIdDepl() {
		return idDepl;
	}


	public void setIdDepl(Integer idDepl) {
		this.idDepl = idDepl;
	}


	public String getAlimentacion() {
		return alimentacion;
	}


	public void setAlimentacion(String alimentacion) {
		this.alimentacion = alimentacion;
	}


	public String getHospedaje() {
		return hospedaje;
	}


	public void setHospedaje(String hospedaje) {
		this.hospedaje = hospedaje;
	}


	public String getTransporte() {
		return transporte;
	}


	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}


	public String getTraslados() {
		return traslados;
	}


	public void setTraslados(String traslados) {
		this.traslados = traslados;
	}


	public Integer getValor() {
		return valor;
	}


	public void setValor(Integer valor) {
		this.valor = valor;
	}


	public Integer getCantidadNoches() {
		return cantidadNoches;
	}


	public void setCantidadNoches(Integer cantidadNoches) {
		this.cantidadNoches = cantidadNoches;
	}


	public Integer getCantidadDias() {
		return cantidadDias;
	}


	public void setCantidadDias(Integer cantidadDias) {
		this.cantidadDias = cantidadDias;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public Date getFechaModificacion() {
		return fechaModificacion;
	}


	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}


	public String getUsuCreador() {
		return usuCreador;
	}


	public void setUsuCreador(String usuCreador) {
		this.usuCreador = usuCreador;
	}


	public String getUsuModificador() {
		return usuModificador;
	}


	public void setUsuModificador(String usuModificador) {
		this.usuModificador = usuModificador;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Integer getIdPlan() {
		return idPlan;
	}


	public void setIdPlan(Integer idPlan) {
		this.idPlan = idPlan;
	}


	public Integer getIdDest() {
		return idDest;
	}


	public void setIdDest(Integer idDest) {
		this.idDest = idDest;
	}
	
	
	
}
