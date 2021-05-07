package co.edu.usbcali.viajes.app.service;

import java.util.List;

import co.edu.usbcali.viajes.app.domain.Cliente;

public interface ClienteService {
	
	public void guardarCliente(Cliente cliente) throws Exception;
	
	public void eliminarCliente(int idCliente) throws Exception;
	
	public void actualizarCliente(Cliente cliente) throws Exception;
	
	public List<Cliente>  consultarTodosClientes() throws Exception;
	
	public Cliente consultarClientePorId(Integer idCliente) throws Exception; 

}
