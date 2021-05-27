package co.edu.usbcali.viajes.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajes.app.domain.Usuario;
import co.edu.usbcali.viajes.app.dto.UsuarioDTO;
import co.edu.usbcali.viajes.app.service.UsuarioServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	
	@Autowired
	private UsuarioServiceImpl usuarioService;

	
	@PostMapping("/guardarUsuario")
	public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioDTO usuario) {
		try {
			
			Usuario usuarioObj = new Usuario(null, usuario.getLogin(), usuario.getPassword(), usuario.getNombre(), usuario.getIdentificacion(), usuario.getFechaCreacion(),    
					null,usuario.getUsuCreador(),null,usuario.getEstado());
			usuarioService.guardarUsuario(usuarioObj);
			return ResponseEntity.ok().body(usuario);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		} 
	}
	
	@PutMapping("/actualizarUsuario")
	public ResponseEntity<?> actualizarUsuario(@RequestBody UsuarioDTO usuario) {
		try {
			
			Usuario usuarioObj = new Usuario(usuario.getIdUsua(), usuario.getLogin(), usuario.getPassword(), usuario.getNombre(), usuario.getIdentificacion(), usuario.getFechaCreacion(),    
					usuario.getFechaModificacion(),usuario.getUsuCreador(),usuario.getUsuModificador(),usuario.getEstado());
			
			usuarioService.actualizarUsuario(usuarioObj);
			return ResponseEntity.ok().body(usuario);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/getUsuarios")
	public ResponseEntity<?> getUsuarios() {
		try {
			return ResponseEntity.ok().body(usuarioService.consultarTodosUsuario());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/getUsuarioPorId")
	public ResponseEntity<?> buscarPlanPorId(@RequestParam("idUsuario") Integer id) {

		try {
			return ResponseEntity.ok().body(usuarioService.consultarUsuarioById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/eliminarUsuario")
	public ResponseEntity<?> eliminarUsuario(@RequestParam("idUsuario") Integer idUsuario) {
		try {
			usuarioService.eliminarUsuario(idUsuario);
			return ResponseEntity.ok().body("Usuario eliminado : " + idUsuario);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
