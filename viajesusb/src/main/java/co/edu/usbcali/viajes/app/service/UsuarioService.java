package co.edu.usbcali.viajes.app.service;

import java.util.List;

import co.edu.usbcali.viajes.app.domain.Usuario;



public interface UsuarioService {
	
	
	public void guardarUsuario(Usuario usuario) throws Exception;

	public void eliminarUsuario(Integer idUsuario) throws Exception;

	public void actualizarUsuario(Usuario usuario) throws Exception;
	
	public Usuario consultarUsuarioById(Integer idUsuario) throws Exception;

	public List<Usuario> consultarTodosUsuario() throws Exception;

}
