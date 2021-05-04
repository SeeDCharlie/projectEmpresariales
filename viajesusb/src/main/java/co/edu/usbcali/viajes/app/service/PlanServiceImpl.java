package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.usbcali.viajes.app.domain.Cliente;
import co.edu.usbcali.viajes.app.domain.Plan;
import co.edu.usbcali.viajes.app.domain.Usuario;
import co.edu.usbcali.viajes.app.repository.PlanRepository;

public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepository planRepository;

	@Autowired
	private ClienteServiceImpl clienteService;

	@Autowired
	private UsuarioServiceImpl usuarioService;

	@Override
	public void guardarPlan(Plan plan) throws Exception {

		try {

			Usuario usr = usuarioService.consultarUsuarioById(plan.getIdUsua().getIdUsua());

			Cliente client = clienteService.consultarClientePorId(plan.getIdClie().getIdClie());

			if (plan.getCodigo().equals("") || plan.getCodigo().equals(null) || plan.getCodigo().length() > 5) {

				throw new Exception("codio incorrecto");
			}
			if (plan.getDescripcionSolicitud().equals("") || plan.getDescripcionSolicitud().equals(null)
					|| plan.getDescripcionSolicitud().length() > 300) {

				throw new Exception("Descripcion Solicitud incorrecta");
			}
			if (plan.getNombre().equals("") || plan.getNombre().equals(null) || plan.getNombre().length() > 100) {

				throw new Exception("nombre incorrecto");
			}
			if (plan.getCantidadPersonas().equals(null)) {

				throw new Exception("codio incorrecto");
			}

			if (plan.getFechaSolicitud().equals(null)) {

				throw new Exception("Fecha Solicitud incorrecta");
			}
			if (plan.getFechaInicioViaje().equals(null)) {

				throw new Exception("Fecha Inicio Viaje incorrecta");
			}
			if (plan.getFechaFinViaje().equals(null)) {

				throw new Exception("Fecha Fin Viaje incorrecta");
			}
			if (plan.getValorTotal().equals(null)) {

				throw new Exception("valor total incorrecto");
			}
			if (plan.getFechaCreacion().equals(null)) {

				throw new Exception("Fecha Creacion incorrecta");
			}
			if (plan.getUsuCreador().equals("") || plan.getUsuCreador().equals(null)
					|| plan.getUsuCreador().length() > 10) {

				throw new Exception("usuario creador incorrecto");
			}
			if (plan.getEstado().equals("") || plan.getEstado().equals(null) || plan.getEstado().length() > 10) {

				throw new Exception("usuario creador incorrecto");
			}
			if (client.equals(null)) {

				throw new Exception("usuario incorrecto");
			}
			if (usr.equals(null)) {

				throw new Exception("cliente incorrecto");
			}

			planRepository.save(plan);
			System.out.println("plan guardado");

		} catch (Exception e) {
			throw new Exception("error: " + e.getMessage());
		}

	}

	@Override
	public void eliminarPlan(Integer idPlan) throws Exception {

		Optional<Plan> pln = planRepository.findById(idPlan);

		if (pln.isEmpty()) {
			throw new Exception("el plan no existe o es incorrecto");
		} else {
			planRepository.delete(pln.get());
			System.out.println("plan eliminado");
		}

	}

	@Override
	public void actualizarPlan(Plan plan) throws Exception {
		try {
			Optional<Plan> pln = planRepository.findById(plan.getIdPlan());
 			if(pln.isEmpty()) {
 				throw new Exception("el plan no existe o es incorrecto");
			}else {
				Usuario usr = usuarioService.consultarUsuarioById(plan.getIdUsua().getIdUsua());

 				Cliente client = clienteService.consultarClientePorId(plan.getIdClie().getIdClie());

 				if (plan.getCodigo().equals("") || plan.getCodigo().equals(null) || plan.getCodigo().length() > 5) {

 					throw new Exception("codio incorrecto");
 				}
 				if (plan.getDescripcionSolicitud().equals("") || plan.getDescripcionSolicitud().equals(null)
 						|| plan.getDescripcionSolicitud().length() > 300) {

 					throw new Exception("Descripcion Solicitud incorrecta");
 				}
 				if (plan.getNombre().equals("") || plan.getNombre().equals(null) || plan.getNombre().length() > 100) {

 					throw new Exception("nombre incorrecto");
 				}
 				if (plan.getCantidadPersonas().equals(null)) {

 					throw new Exception("codio incorrecto");
 				}

 				if (plan.getFechaSolicitud().equals(null)) {

 					throw new Exception("Fecha Solicitud incorrecta");
 				}
 				if (plan.getFechaInicioViaje().equals(null)) {

 					throw new Exception("Fecha Inicio Viaje incorrecta");
 				}
 				if (plan.getFechaFinViaje().equals(null)) {

 					throw new Exception("Fecha Fin Viaje incorrecta");
 				}
 				if (plan.getValorTotal().equals(null)) {

 					throw new Exception("valor total incorrecto");
 				}
 				if (plan.getFechaCreacion().equals(null)) {

 					throw new Exception("Fecha Creacion incorrecta");
 				}
 				if (plan.getFechaModificacion().equals(null)) {

 					throw new Exception("Fecha modificacion incorrecta");
 				}
 				if (plan.getUsuCreador().equals("") || plan.getUsuCreador().equals(null)
 						|| plan.getUsuCreador().length() > 10) {
 					throw new Exception("usuario creador incorrecto");
 				}
 				if (plan.getUsuModificador().equals("") || plan.getUsuModificador().equals(null)
 						|| plan.getUsuModificador().length() > 10) {
 					throw new Exception("usuario modificador incorrecto");
 				}
 				if (plan.getEstado().equals("") || plan.getEstado().equals(null) || plan.getEstado().length() > 10) {

 					throw new Exception("usuario creador incorrecto");
 				}
 				if (client.equals(null)) {

 					throw new Exception("usuario incorrecto");
 				}
 				if (usr.equals(null)) {

 					throw new Exception("cliente incorrecto");
 				}

 				planRepository.save(plan);
 				System.out.println("plan actualizado");
				
			}

		} catch (Exception e) {
			throw new Exception("error: " + e.getMessage());
		}

	}

	@Override
	public List<Plan> consultarTodosPlan() throws Exception {
		List<Plan> planes = planRepository.findAll();
		if(planes.isEmpty()) {
			throw new Exception("lista de planes vacia");
		}else {
			return planes;
		}
	}

	@Override
	public Plan consultarPlanPorId(Integer idPlan) throws Exception {
		Optional<Plan> pln = planRepository.findById(idPlan);
		
		if(pln.isEmpty()) {
			throw new Exception("el plan no existe o el id esincorrecto");
		}else {
			return pln.get();
		}
	}

}
