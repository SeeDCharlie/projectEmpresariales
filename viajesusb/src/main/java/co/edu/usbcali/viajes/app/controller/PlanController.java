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
import co.edu.usbcali.viajes.app.domain.Plan;
import co.edu.usbcali.viajes.app.domain.Usuario;
import co.edu.usbcali.viajes.app.dto.PlanDTO;
import co.edu.usbcali.viajes.app.service.ClienteServiceImpl;
import co.edu.usbcali.viajes.app.service.PlanServiceImpl;
import co.edu.usbcali.viajes.app.service.UsuarioServiceImpl;


@RestController
@RequestMapping("/api/plan")
public class PlanController {
	
	@Autowired
	private PlanServiceImpl planService;
	
	@Autowired
	private ClienteServiceImpl clienteService;
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	
	@PostMapping("/guardarPlan")
	public ResponseEntity<?> guardarPlan(@RequestBody PlanDTO plan) {
		try {
			Cliente cli = clienteService.consultarClientePorId(plan.getIdClie());
			Usuario usr = usuarioService.consultarUsuarioById(plan.getIdUsua());
			Plan planObj = new Plan(null, plan.getCodigo(), plan.getDescripcionSolicitud(), plan.getNombre(), plan.getCantidadPersonas(),
					plan.getFechaSolicitud(), plan.getFechaInicioViaje(), plan.getFechaFinViaje(), plan.getValorTotal(), plan.getFechaCreacion(), null,
					plan.getUsuCreador(), null, plan.getEstado(), cli, usr);
			planService.guardarPlan(planObj);
			return ResponseEntity.ok().body(plan);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping("/actualizarPlan")
	public ResponseEntity<?> actualizarPlan(@RequestBody PlanDTO plan) {
		try {
			
			Cliente cli = clienteService.consultarClientePorId(plan.getIdClie());
			Usuario usr = usuarioService.consultarUsuarioById(plan.getIdUsua());
			Plan planObj = new Plan(plan.getIdPlan(), plan.getCodigo(), plan.getDescripcionSolicitud(), plan.getNombre(), plan.getCantidadPersonas(),
					plan.getFechaSolicitud(), plan.getFechaInicioViaje(), plan.getFechaFinViaje(), plan.getValorTotal(), plan.getFechaCreacion(), plan.getFechaModificacion(),
					plan.getUsuCreador(), plan.getUsuModificador(), plan.getEstado(), cli, usr);
			planService.actualizarPlan(planObj);
			return ResponseEntity.ok().body(plan);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/getPlans")
	public ResponseEntity<?> getPlans() {
		try {
			return ResponseEntity.ok().body(planService.consultarTodosPlan());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/eliminarPlan")
	public ResponseEntity<?> eliminarPlan(@RequestParam("idPlan") Integer idPlan) {
		try {
			planService.eliminarPlan(idPlan);
			return ResponseEntity.ok().body("Plan eliminado : " + idPlan);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
