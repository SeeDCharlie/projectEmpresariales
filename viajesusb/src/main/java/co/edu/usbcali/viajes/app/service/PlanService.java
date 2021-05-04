package co.edu.usbcali.viajes.app.service;

import java.util.List;

import co.edu.usbcali.viajes.app.domain.Plan;

public interface PlanService {
	
	public void guardarPlan(Plan plan) throws Exception;
	
	public void eliminarPlan(Integer idPlan) throws Exception;
	
	public void actualizarPlan(Plan plan) throws Exception;
	
	public List<Plan>  consultarTodosPlan() throws Exception;
	
	public Plan consultarPlanPorId(Integer idPlan) throws Exception; 

}
