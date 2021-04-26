package co.edu.usbcali.viajes.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.usbcali.viajes.app.domain.Cliente;
import co.edu.usbcali.viajes.app.dto.ClienteDTO;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	
	public Cliente findByNumeroIdentificacion(String numeroIdentificacion);
	
	public Cliente findByCorreo(String correo);

	public List<Cliente> findByEstado(String estado);
	
	public List<Cliente> findByNombreLike(String nom);
	
	public List<Cliente> findByFechaNacimientoBetween(Date fechaInicio, Date fechFin);
	
	public List<Cliente> findByNumeroIdentificacionLike(String numeroIdentificacion);
	
	@Query(nativeQuery = true)
	public List<ClienteDTO> consultarClientePorCodigoDeTipoIdentificacion(@Param("pCodigo")String cod);
}
