package co.edu.usbcali.viajes.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import co.edu.usbcali.viajes.app.domain.TipoDestino;
import co.edu.usbcali.viajes.app.dto.TipoDestinoDTO;

public interface TipoDestinoRepository extends JpaRepository<TipoDestino, Integer> {
	
	//consultar por rango de fechas
	public List<TipoDestino> findByFechaCreacionBetween(Date fechaInicio, Date fechFin);
	
	//lista de tipos de destino por estado
	@Query(nativeQuery = true)
	public List<TipoDestinoDTO> consultarTipoDestinoPorEstado(@Param("pEstado")String estado);
	
	public TipoDestino findByCodigo(String codigo);
	
}
