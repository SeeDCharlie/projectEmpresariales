package co.edu.usbcali.viajes.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.usbcali.viajes.app.domain.Destino;


public interface DestinoService {
	
	
	public void guardarDestino(Destino destino) throws Exception;
	
	public void eliminarDestino(int destino) throws Exception;
	
	public void actualizarDestino(Destino destino) throws Exception;
	
	public Destino consultarDestino(int idDestino) throws Exception;
	
	public List<Destino> consultarTodosDestinos() throws Exception;
	
}
