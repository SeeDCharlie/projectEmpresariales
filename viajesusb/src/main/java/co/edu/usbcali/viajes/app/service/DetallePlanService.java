package co.edu.usbcali.viajes.app.service;

import java.util.List;

import co.edu.usbcali.viajes.app.domain.DetallePlan;



public interface DetallePlanService {
	
	public void guardarDetallePlan(DetallePlan detallePlan) throws Exception;
	
	public void eliminarDetallePlan(Integer idDetallePlan) throws Exception;
	
	public void actualizarDetallePlan(DetallePlan detallePlan) throws Exception;
	
	public List<DetallePlan>  consultarTodosDetallePlan() throws Exception;
	
	public DetallePlan consultarDetallePlanPorId(Integer idDetallePlan) throws Exception; 

}
