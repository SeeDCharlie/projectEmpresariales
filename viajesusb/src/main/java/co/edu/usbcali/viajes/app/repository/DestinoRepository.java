package co.edu.usbcali.viajes.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajes.app.domain.Destino;
import co.edu.usbcali.viajes.app.domain.TipoDestino;

public interface DestinoRepository extends JpaRepository<Destino, Integer> {

	
	public List<Destino> findByTipoDestino_codigo(String codigo);
	
	
}
