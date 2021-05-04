package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.usbcali.viajes.app.domain.Destino;
import co.edu.usbcali.viajes.app.domain.DetallePlan;
import co.edu.usbcali.viajes.app.domain.Plan;
import co.edu.usbcali.viajes.app.repository.DetallePlanRepository;

public class DetallePlanServiceImpl implements DetallePlanService {

	@Autowired
	private DetallePlanRepository detallePlanRepository;

	@Autowired
	private PlanServiceImpl planService;

	@Autowired
	private DestinoServiceImpl destinoService;

	@Override
	public void guardarDetallePlan(DetallePlan detallePlan) throws Exception {

		try {

			Plan pln = planService.consultarPlanPorId(detallePlan.getIdPlan().getIdPlan());

			Destino dest = destinoService.consultarDestino(detallePlan.getIdDest().getIdDest());

			if (detallePlan.getAlimentacion().equals("") || detallePlan.getAlimentacion().equals(null)
					|| detallePlan.getAlimentacion().length() > 1) {
				throw new Exception("alimentacion incorrecto");
			}
			if (detallePlan.getHospedaje().equals("") || detallePlan.getHospedaje().equals(null)
					|| detallePlan.getHospedaje().length() > 1) {
				throw new Exception("hospedaje incorrecto");
			}
			if (detallePlan.getTransporte().equals("") || detallePlan.getTransporte().equals(null)
					|| detallePlan.getTransporte().length() > 1) {
				throw new Exception("transporte incorrecto");
			}
			if (detallePlan.getTraslados().equals("") || detallePlan.getTraslados().equals(null)
					|| detallePlan.getTraslados().length() > 1) {
				throw new Exception("traslados incorrecto");
			}
			if (detallePlan.getValor().equals(null)) {
				throw new Exception("valor incorrecto");
			}
			if (detallePlan.getCantidad_noches().equals(null)) {
				throw new Exception("catidad noche incorrecto");
			}
			if (detallePlan.getcantidadDias().equals(null)) {
				throw new Exception("cantidad dias incorrecto");
			}
			if (detallePlan.getFechaCreacion().equals(null)) {
				throw new Exception("fecha creacion incorrecto");
			}
			if (detallePlan.getUsuCreador().equals("") || detallePlan.getUsuCreador().equals(null)
					|| detallePlan.getUsuCreador().length() > 10) {
				throw new Exception("usuario creador incorrecto");
			}
			if (detallePlan.getEstado().equals("") || detallePlan.getEstado().equals(null)
					|| detallePlan.getEstado().length() > 1) {
				throw new Exception("estado incorrecto");
			}

			if (pln.equals(null)) {
				throw new Exception("plan incorrecto");
			}
			if (dest.equals(null)) {
				throw new Exception("destino incorrecto");
			}

			detallePlanRepository.save(detallePlan);
			System.out.println("detalle plan guardado");

		} catch (Exception e) {
			throw new Exception("error inesperado :" + e.getMessage());
		}

	}

	@Override
	public void actualizarDetallePlan(DetallePlan detallePlan) throws Exception {
		try {

			Optional<DetallePlan> detPlan = detallePlanRepository.findById(detallePlan.getIdDepl());

			if (detPlan.isEmpty()) {
				throw new Exception("El id es incorrecto o No existe");
			} else {
				Plan pln = planService.consultarPlanPorId(detallePlan.getIdPlan().getIdPlan());

				Destino dest = destinoService.consultarDestino(detallePlan.getIdDest().getIdDest());

				if (detallePlan.getAlimentacion().equals("") || detallePlan.getAlimentacion().equals(null)
						|| detallePlan.getAlimentacion().length() > 1) {
					throw new Exception("alimentacion incorrecto");
				}
				if (detallePlan.getHospedaje().equals("") || detallePlan.getHospedaje().equals(null)
						|| detallePlan.getHospedaje().length() > 1) {
					throw new Exception("hospedaje incorrecto");
				}
				if (detallePlan.getTransporte().equals("") || detallePlan.getTransporte().equals(null)
						|| detallePlan.getTransporte().length() > 1) {
					throw new Exception("transporte incorrecto");
				}
				if (detallePlan.getTraslados().equals("") || detallePlan.getTraslados().equals(null)
						|| detallePlan.getTraslados().length() > 1) {
					throw new Exception("traslados incorrecto");
				}
				if (detallePlan.getValor().equals(null)) {
					throw new Exception("valor incorrecto");
				}
				if (detallePlan.getCantidad_noches().equals(null)) {
					throw new Exception("catidad noche incorrecto");
				}
				if (detallePlan.getcantidadDias().equals(null)) {
					throw new Exception("cantidad dias incorrecto");
				}
				if (detallePlan.getFechaCreacion().equals(null)) {
					throw new Exception("fecha creacion incorrecto");
				}
				if (detallePlan.getFechaModificacion().equals(null)) {
					throw new Exception("fecha modificacion incorrecto");
				}
				if (detallePlan.getUsuCreador().equals("") || detallePlan.getUsuCreador().equals(null)
						|| detallePlan.getUsuCreador().length() > 10) {
					throw new Exception("usuario creador incorrecto");
				}
				if (detallePlan.getUsuModificador().equals("") || detallePlan.getUsuModificador().equals(null)
						|| detallePlan.getUsuModificador().length() > 10) {
					throw new Exception("usuario modificador incorrecto");
				}
				if (detallePlan.getEstado().equals("") || detallePlan.getEstado().equals(null)
						|| detallePlan.getEstado().length() > 1) {
					throw new Exception("estado incorrecto");
				}

				if (pln.equals(null)) {
					throw new Exception("plan incorrecto");
				}
				if (dest.equals(null)) {
					throw new Exception("destino incorrecto");
				}

				detallePlanRepository.save(detallePlan);
				System.out.println("detalle plan actualizado");
			}

		} catch (Exception e) {
			throw new Exception("error inesperado :" + e.getMessage());
		}

	}

	@Override
	public void eliminarDetallePlan(Integer idDetallePlan) throws Exception {
		Optional<DetallePlan> detPlan = detallePlanRepository.findById(idDetallePlan);

		if (detPlan.isEmpty()) {
			throw new Exception("el id es incorreeecto o no existe");
		} else {
			detallePlanRepository.delete(detPlan.get());
			System.out.println("detalle plan eliminado");
		}

	}

	@Override
	public List<DetallePlan> consultarTodosDetallePlan() throws Exception {

		List<DetallePlan> lista = detallePlanRepository.findAll();
		if (lista.isEmpty()) {
			throw new Exception("lista vacia");
		} else {
			return lista;
		}
	}

	@Override
	public DetallePlan consultarDetallePlanPorId(Integer idDetallePlan) throws Exception {
		Optional<DetallePlan> detPlan = detallePlanRepository.findById(idDetallePlan);

		if (detPlan.isEmpty()) {
			throw new Exception("el id es incorreeecto o no existe");
		} else {
			return detPlan.get();
		}
	}

}
