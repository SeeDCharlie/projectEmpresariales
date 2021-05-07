package co.edu.usbcali.viajes.app.controller;

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

import co.edu.usbcali.viajes.app.domain.Cliente;
import co.edu.usbcali.viajes.app.domain.Destino;
import co.edu.usbcali.viajes.app.domain.DetallePlan;
import co.edu.usbcali.viajes.app.domain.Plan;
import co.edu.usbcali.viajes.app.domain.Usuario;
import co.edu.usbcali.viajes.app.dto.DetallePlanDTO;
import co.edu.usbcali.viajes.app.service.ClienteServiceImpl;
import co.edu.usbcali.viajes.app.service.DestinoServiceImpl;
import co.edu.usbcali.viajes.app.service.DetallePlanServiceImpl;
import co.edu.usbcali.viajes.app.service.PlanServiceImpl;
import co.edu.usbcali.viajes.app.service.UsuarioServiceImpl;


@RestController
@RequestMapping("/api/detallePlan")
public class DetallePlanController {
	
	@Autowired
	private DetallePlanServiceImpl detallePlanService;
	
	@Autowired
	private PlanServiceImpl planService;
	
	@Autowired
	private DestinoServiceImpl destinoService;
	

	
	
	@PostMapping("/guardarDetallePlan")
	public ResponseEntity<?> guardarDetallePlan(@RequestBody DetallePlanDTO detallePlan) {
		try {
			
			Plan pln = planService.consultarPlanPorId(detallePlan.getIdPlan());
			Destino desti = destinoService.consultarDestino(detallePlan.getIdDest());

			DetallePlan detallePlanObj = new DetallePlan(null, detallePlan.getAlimentacion(), detallePlan.getHospedaje(), detallePlan.getTransporte(),
					detallePlan.getTraslados(), detallePlan.getValor(), detallePlan.getCantidadNoches(), detallePlan.getCantidadDias(),
					detallePlan.getFechaCreacion(), null, detallePlan.getUsuCreador(), null, detallePlan.getEstado(), pln, desti);
			detallePlanService.guardarDetallePlan(detallePlanObj);
			
			return ResponseEntity.ok().body(detallePlan);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping("/actualizarDetallePlan")
	public ResponseEntity<?> actualizarDetallePlan(@RequestBody DetallePlanDTO detallePlan) {
		try {
			
			Plan pln = planService.consultarPlanPorId(detallePlan.getIdPlan());
			Destino desti = destinoService.consultarDestino(detallePlan.getIdDest());

			DetallePlan detallePlanObj = new DetallePlan(detallePlan.getIdDepl(), detallePlan.getAlimentacion(), detallePlan.getHospedaje(), detallePlan.getTransporte(),
					detallePlan.getTraslados(), detallePlan.getValor(), detallePlan.getCantidadNoches(), detallePlan.getCantidadDias(),
					detallePlan.getFechaCreacion(), detallePlan.getFechaCreacion(), detallePlan.getUsuCreador(), detallePlan.getUsuModificador(), detallePlan.getEstado(), pln, desti);
			detallePlanService.actualizarDetallePlan(detallePlanObj);
			return ResponseEntity.ok().body(detallePlan);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/getDetallePlan")
	public ResponseEntity<?> getDetallePlans() {
		try {
			return ResponseEntity.ok().body(detallePlanService.consultarTodosDetallePlan());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/eliminarDetallePlan")
	public ResponseEntity<?> eliminarDetallePlan(@RequestParam("idDetallePlan") Integer idDetallePlan) {
		try {
			detallePlanService.eliminarDetallePlan(idDetallePlan);
			return ResponseEntity.ok().body("DetallePlan eliminado : " + idDetallePlan);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/getDetallePlanPorId")
	public ResponseEntity<?> buscarPlanPorId(@RequestParam("idDetallePlan") Integer id) {

		try {
			return ResponseEntity.ok().body(detallePlanService.consultarDetallePlanPorId(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
