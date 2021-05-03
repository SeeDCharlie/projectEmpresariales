package co.edu.usbcali.viajes.app.dto;

import java.util.Date;

import javax.persistence.Column;

public class UsuarioDTO {

	
	
	private Integer idUsua;
	private String login;
	private String password;
	private String nombre;
	private String identificacion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String usuCreador;
	private String usuModificador;
	private String estado;
	
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioDTO(Integer idUsua, String login, String password, String nombre, String identificacion,
			Date fechaCreacion, Date fechaModificacion, String usuCreador, String usuModificador, String estado) {
		super();
		this.idUsua = idUsua;
		this.login = login;
		this.password = password;
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuCreador = usuCreador;
		this.usuModificador = usuModificador;
		this.estado = estado;
	}

	public Integer getIdUsua() {
		return idUsua;
	}

	public void setIdUsua(Integer idUsua) {
		this.idUsua = idUsua;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
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
