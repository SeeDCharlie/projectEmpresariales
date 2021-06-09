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

import co.edu.usbcali.viajes.app.domain.Destino;
import co.edu.usbcali.viajes.app.domain.TipoDestino;
import co.edu.usbcali.viajes.app.dto.DestinoDTO;
import co.edu.usbcali.viajes.app.dto.TipoDestinoDTO;
import co.edu.usbcali.viajes.app.mapper.DestinoMapper;
import co.edu.usbcali.viajes.app.service.DestinoServiceImpl;
import co.edu.usbcali.viajes.app.service.TipoDestinoServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/destino")
public class DestinoRestController {
	
	@Autowired
	private DestinoServiceImpl destinoService;
	
	@Autowired
	private TipoDestinoServiceImpl tipoDestinoService;
	
	@Autowired
	private DestinoMapper destinoMapper;
	
	@PostMapping("/guardarDestino")
	public ResponseEntity<?> guardarDestino(@RequestBody DestinoDTO destino) {
		try {
			
			TipoDestino td = tipoDestinoService.consultarTiposDestinoPorCodigo(destino.getTipoDestino().getCodigo());
			System.out.println("codigo tipo destino t : " + td.getCodigo());
			Destino destinoObj = new Destino(destino.getIdDest(),destino.getNombre() , destino.getCodigo(), destino.getDescripcion(), destino.getTierra(),
					destino.getAire(), destino.getMar(), destino.getFechaCreacion(), destino.getFechaModificacion(), destino.getUsuCreador(), destino.getUsuModificador(),
					destino.getEstado(), td);
			destinoService.guardarDestino(destinoObj);
			
			
			return ResponseEntity.ok().body(destinoMapper.destinoToDestinoDTO(destinoObj));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping("/actualizarDestino")
	public ResponseEntity<?> actualizarDestino(@RequestBody DestinoDTO destino) {
		try {
			
			TipoDestino td = tipoDestinoService.consultarTipoDestinoPorId(destino.getTipoDestino().getIdTide());
			Destino destinoObj = new Destino(destino.getIdDest(),destino.getNombre() , destino.getCodigo(), destino.getDescripcion(), destino.getTierra(),
					destino.getAire(), destino.getMar(), destino.getFechaCreacion(), destino.getFechaModificacion(), destino.getUsuCreador(), destino.getUsuModificador(),
					destino.getEstado(), td);
			destinoService.actualizarDestino(destinoObj);
			return ResponseEntity.ok().body(destino);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/getDestinoPorId")
	public ResponseEntity<?> getDestinoPorId(@RequestParam("id") Integer id) {
		try {
			return ResponseEntity.ok().body(destinoService.consultarDestino(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/getDestinos")
	public ResponseEntity<?> getDestinos() {
		try {
			return ResponseEntity.ok().body(destinoService.consultarTodosDestinos());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/eliminarDestino")
	public ResponseEntity<?> eliminarDestino(@RequestParam("idDestino") Integer idDest) {
		try {
			destinoService.eliminarDestino(idDest);
			return ResponseEntity.ok().body("destino eliminado : " + idDest);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
}
