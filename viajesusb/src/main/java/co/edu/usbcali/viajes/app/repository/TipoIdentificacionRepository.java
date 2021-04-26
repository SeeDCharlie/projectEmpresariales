package co.edu.usbcali.viajes.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajes.app.domain.TipoIdentificacion;

public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacion, Integer> {

}
