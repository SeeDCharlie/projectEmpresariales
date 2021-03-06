package co.edu.usbcali.viajes.app.service;

import java.util.List;

import co.edu.usbcali.viajes.app.domain.TipoIdentificacion;


public interface TipoIdentificacionService {
	
	public void guardarTipoIdentificacion(TipoIdentificacion tipoIdentificacion) throws Exception;

	public void eliminarTipoIdentificacion(int idTipoIdentificacion) throws Exception;

	public void actualizarTipoIdentificacion(TipoIdentificacion tipoIdentificacion) throws Exception;
	
	public TipoIdentificacion consultarTipoIdentificacionById(int idTiid) throws Exception;

	public List<TipoIdentificacion> consultarTodosTipoIdentificacion() throws Exception;

}
