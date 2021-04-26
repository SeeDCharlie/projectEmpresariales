package co.edu.usbcali.viajes.app.dto;

import java.util.Date;

import javax.persistence.Column;

public class TipoIdentificacionDTO {

	
	private Integer idTiid;
	private String codigo;
	private String nombre;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String usuCreador;
	private String usuModificador;
	private String estado;
	
	
	
	public TipoIdentificacionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoIdentificacionDTO(Integer idTiid, String codigo, String nombre, Date fechaCreacion,
			Date fechaModificacion, String usuCreador, String usuModificador, String estado) {
		super();
		this.idTiid = idTiid;
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuCreador = usuCreador;
		this.usuModificador = usuModificador;
		this.estado = estado;
	}

	public Integer getIdTiid() {
		return idTiid;
	}

	public void setIdTiid(Integer idTiid) {
		this.idTiid = idTiid;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
}
