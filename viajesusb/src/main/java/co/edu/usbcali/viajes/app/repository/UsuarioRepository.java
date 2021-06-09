package co.edu.usbcali.viajes.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajes.app.domain.Usuario;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	
	public List<Usuario> findByLogin(String login);

}
