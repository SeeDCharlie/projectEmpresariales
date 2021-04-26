package co.edu.usbcali.viajes.app.service;

import java.util.Date;
import java.util.List;

import co.edu.usbcali.viajes.app.domain.Destino;
import co.edu.usbcali.viajes.app.domain.TipoDestino;

public interface TipoDestinoService {

	public void guardarTipoDestino(TipoDestino tipoDestino) throws Exception;

	public void eliminarTipoDestino(int idTd) throws Exception;
	
	//@Mapper(componentModel = "spring")
	public void actualizarTipoDestino(TipoDestino tipoDestino) throws Exception;
	
	public TipoDestino consultarTipoDestinoPorId(int id) throws Exception;

	public List<TipoDestino> consultarTiposDestino() throws Exception;
	
	public TipoDestino consultarTiposDestinoPorCodigo(String codigo) throws Exception;
}
