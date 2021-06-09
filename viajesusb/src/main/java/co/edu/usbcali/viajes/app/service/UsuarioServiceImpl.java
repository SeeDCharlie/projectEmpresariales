package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajes.app.domain.Usuario;
import co.edu.usbcali.viajes.app.dto.UsuarioDTO;
import co.edu.usbcali.viajes.app.repository.UsuarioRepository;
import net.bytebuddy.implementation.bytecode.Throw;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void guardarUsuario(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		
		List<Usuario> usrsByLogin = usuarioRepository.findByLogin(usuario.getLogin());
		
		if (!usrsByLogin.isEmpty()) {
			throw new Exception("el nombre del login ya existe");
		}		
		if(usuario.getLogin().equals("") || usuario.getLogin().equals(null) || usuario.getLogin().length() > 10 ) {
			throw new Exception("login incorrecto");
		}
		if(usuario.getPassword().equals("") || usuario.getPassword().equals(null) || usuario.getPassword().length() > 50 ) {
			throw new Exception("Contraseña incorrecta");
		}
		if(usuario.getNombre().equals("") || usuario.getNombre().equals(null ) || usuario.getNombre().length() > 100) {
			throw new Exception("nombre incorrecto");
		}
		if(usuario.getIdentificacion().equals("") || usuario.getIdentificacion().equals(null) || usuario.getIdentificacion().length() > 15) {
			throw new Exception("identificacion incorrecta");
		}
		if(usuario.getFechaCreacion().equals(null)) {
			throw new Exception("fecha creacion incorrecta");
		}
		if(usuario.getUsuCreador().equals("") || usuario.getUsuCreador().equals(null) || usuario.getUsuCreador().length() > 10) {
			throw new Exception("usuario creador incorrecto");
		}
		if(usuario.getEstado().equals("") || usuario.getEstado().equals(null) || usuario.getEstado().length() > 1 ) {
			throw new Exception("estado incorrecto");
		}
		
		usuarioRepository.save(usuario);
		System.out.println("usuario guardado");
		
	}

	@Override
	public void eliminarUsuario(Integer idUsuario) throws Exception {
		
		Optional<Usuario> usr = usuarioRepository.findById(idUsuario);
		
		if(usr.isEmpty()) {
			throw new Exception("id usuario incorrecto o no existe");
		}else {
			usuarioRepository.delete(usr.get());
			System.out.println("usuario eliminado");
		}

	}

	@Override
	public void actualizarUsuario(Usuario usuario) throws Exception {
		
		if(usuario.getIdUsua().equals(null)) {
			throw new Exception("id usuario incorrecto");
		}else {
			
			Optional<Usuario> usr = usuarioRepository.findById(usuario.getIdUsua());
			
			if(usr.isEmpty()  ) {
				throw new Exception("el usuario no existe");
			}else {
				if(usuario.getLogin().equals("") || usuario.getLogin().equals(null) || usuario.getLogin().length() > 10 ) {
					throw new Exception("login incorrecto");
				}
				if(usuario.getPassword().equals("") || usuario.getPassword().equals(null) || usuario.getPassword().length() > 50 ) {
					throw new Exception("Contraseña incorrecta");
				}
				if(usuario.getNombre().equals("") || usuario.getNombre().equals(null ) || usuario.getNombre().length() > 100) {
					throw new Exception("nombre incorrecto");
				}
				if(usuario.getIdentificacion().equals("") || usuario.getIdentificacion().equals(null) || usuario.getIdentificacion().length() > 15) {
					throw new Exception("identificacion incorrecta");
				}
				if(usuario.getFechaCreacion().equals(null)) {
					throw new Exception("fecha creacion incorrecta");
				}
				if(usuario.getFechaModificacion().equals(null)) {
					throw new Exception("fecha modificacion incorrecta");
				}
				if(usuario.getUsuCreador().equals("") || usuario.getUsuCreador().equals(null) || usuario.getUsuCreador().length() > 10) {
					throw new Exception("usuario creador incorrecto");
				}
				if(usuario.getUsuModificador().equals("") || usuario.getUsuModificador().equals(null) || usuario.getUsuModificador().length() > 10) {
					throw new Exception("usuario modificador incorrecto");
				}
				if(usuario.getEstado().equals("") || usuario.getEstado().equals(null) || usuario.getEstado().length() > 1 ) {
					throw new Exception("estado incorrecto");
				}
				
				usuarioRepository.save(usuario);
				System.out.println("usuario actualizado");
			}
		}
	}

	@Override
	public Usuario consultarUsuarioById(Integer idUsuario) throws Exception {
		
		Optional<Usuario> usr = usuarioRepository.findById(idUsuario);
		if(usr.isEmpty()) {
			throw new Exception("id usuario incorrecto o no existe");
		}else {
			return usr.get();
		}
	}

	@Override
	public List<Usuario> consultarTodosUsuario() throws Exception {
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		if(usuarios.isEmpty()) {
			throw new Exception("lista de usuario vacia");
		}else {
			return usuarios;
		}
	}

	@Override
	public Usuario loggin(UsuarioDTO usr) throws Exception {
		List<Usuario> usrExist = usuarioRepository.findByLogin(usr.getLogin() );
		
		if(usrExist.isEmpty()) {
			throw new Exception("El usuario no existe");
		}
		Usuario usrLogin = usrExist.get(0);
		
		if (!usr.getPassword().equals(usrLogin.getPassword())) {
			throw new Exception("Contraseña incorrecta");
		}
		
		return usrExist.get(0);
	}

}
