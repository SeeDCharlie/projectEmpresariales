package co.edu.usbcali.viajes.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.usbcali.viajes.app.domain.TipoDestino;
import co.edu.usbcali.viajes.app.dto.TipoDestinoDTO;
import co.edu.usbcali.viajes.app.service.TipoDestinoService;
import co.edu.usbcali.viajes.app.service.TipoDestinoServiceImpl;

@RestController
@RequestMapping("/api/tipoDestino")
public class TipoDestinoRestController {

	@Autowired
	private TipoDestinoServiceImpl tipoDestinoDestinoService;

	@GetMapping("/getTiposDestino")
	public ResponseEntity<?> buscarTodosTipoDestino() {

		try {
			return ResponseEntity.ok().body(tipoDestinoDestinoService.consultarTiposDestino());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping("/getTiposDestinoPorCodigo")
	public ResponseEntity<?> buscarTodosTipoDestinoPorCodigo(@RequestParam("codigo") String codigo) {

		try {
			return ResponseEntity.ok().body(tipoDestinoDestinoService.consultarTiposDestinoPorCodigo(codigo));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PostMapping("/guardarTipoDestino")
	public ResponseEntity<?> guardarTipoDestino(@RequestBody TipoDestinoDTO tdDto) {

		try {
			TipoDestino td = new TipoDestino(null, tdDto.getCodigo(), tdDto.getNombre(), tdDto.getDescripcion(),
					tdDto.getFechaCreacion(), null, tdDto.getUsuCreador(), null, tdDto.getEstado());
			tipoDestinoDestinoService.guardarTipoDestino(td);
			return ResponseEntity.ok().body(tdDto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PutMapping("/actualizarTipoDestino")
	public ResponseEntity<?> actualizarTipoDestino(@RequestBody TipoDestinoDTO tdDto) {

		try {
			TipoDestino td = new TipoDestino(tdDto.getIdTide(), tdDto.getCodigo(), tdDto.getNombre(), tdDto.getDescripcion(),
					tdDto.getFechaCreacion(), tdDto.getFechaModificacion(), tdDto.getUsuCreador(), tdDto.getUsuModificador(), tdDto.getEstado());
			tipoDestinoDestinoService.actualizarTipoDestino(td);
			return ResponseEntity.ok().body(tdDto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	@DeleteMapping("/eliminarTipoDestino")
	public ResponseEntity<?> eliminarTipoDestino(@RequestParam("idTipoDestino") Integer idTd) {

		try {

			tipoDestinoDestinoService.eliminarTipoDestino(idTd);
			return ResponseEntity.ok().body("tipo destino eliminado : " + idTd);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
}
