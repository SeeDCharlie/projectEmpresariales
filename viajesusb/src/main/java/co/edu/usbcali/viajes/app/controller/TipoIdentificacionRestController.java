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

import co.edu.usbcali.viajes.app.domain.TipoIdentificacion;
import co.edu.usbcali.viajes.app.dto.TipoIdentificacionDTO;
import co.edu.usbcali.viajes.app.service.TipoIdentificacionServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/tipoIdentificacion")
public class TipoIdentificacionRestController {

	@Autowired
	private TipoIdentificacionServiceImpl tipoIdentificacionService;

	@GetMapping("/getTiposIdentificacion")
	public ResponseEntity<?> buscarTodosTipoIdentificacion() {

		try {
			return ResponseEntity.ok().body(tipoIdentificacionService.consultarTodosTipoIdentificacion());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping("/getTiposIdentificacionPorId")
	public ResponseEntity<?> buscarTipoIdentificacionPorId(@RequestParam("id") Integer id) {

		try {
			return ResponseEntity.ok().body(tipoIdentificacionService.consultarTipoIdentificacionById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PostMapping("/guardarTipoIdentificacion")
	public ResponseEntity<?> guardarTipoIdentificacion(@RequestBody TipoIdentificacionDTO tipoIdent) {

		try {
			TipoIdentificacion ti = new TipoIdentificacion(null, tipoIdent.getCodigo(), tipoIdent.getNombre(),
					tipoIdent.getFechaCreacion(), null, tipoIdent.getUsuCreador(), null, tipoIdent.getEstado());
			tipoIdentificacionService.guardarTipoIdentificacion(ti);
			return ResponseEntity.ok().body(tipoIdent);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping("/actualizarTipoIdentificacion")
	public ResponseEntity<?> actualizarTipoIdentificacion(@RequestBody TipoIdentificacionDTO tipoIdent) {

		try {
			TipoIdentificacion ti = new TipoIdentificacion(tipoIdent.getIdTiid(), tipoIdent.getCodigo(), 
					tipoIdent.getNombre(), tipoIdent.getFechaCreacion(), tipoIdent.getFechaModificacion(),
					tipoIdent.getUsuCreador(), tipoIdent.getUsuModificador(), tipoIdent.getEstado());
			tipoIdentificacionService.actualizarTipoIdentificacion(ti);
			return ResponseEntity.ok().body(tipoIdent);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/eliminarTipoIdentificacionPorId")
	public ResponseEntity<?> eliminarTipoIdentificacionPorId(@RequestParam Integer idTipoIdent) {

		try {
			tipoIdentificacionService.eliminarTipoIdentificacion(idTipoIdent);
			return ResponseEntity.ok().body("tipo de identificacion eliminado : " + idTipoIdent);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
