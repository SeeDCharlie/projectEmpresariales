package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajes.app.domain.Cliente;
import co.edu.usbcali.viajes.app.domain.Destino;
import co.edu.usbcali.viajes.app.domain.TipoDestino;
import co.edu.usbcali.viajes.app.repository.ClienteRepository;
import co.edu.usbcali.viajes.app.repository.TipoDestinoRepository;
import co.edu.usbcali.viajes.app.repository.TipoIdentificacionRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private TipoIdentificacionRepository tipoIndetRepository;

	@Override
	public void guardarCliente(Cliente cliente) throws Exception {
		if (cliente == null) {
			throw new Exception("debeingresar un cliente valido");
		}
		if (cliente.getNumeroIdentificacion() == null || cliente.getNumeroIdentificacion().equals("")
				|| cliente.getNumeroIdentificacion().length() > 15) {
			throw new Exception("numero identificacion no valido");
		}
		if (cliente.getPrimerApellido() == null || cliente.getPrimerApellido().equals("")
				|| cliente.getPrimerApellido().length() > 100) {
			throw new Exception("apellido no valido");
		}
		if (cliente.getSegundoApellido() == null || cliente.getSegundoApellido().equals("")
				|| cliente.getSegundoApellido().length() > 100) {
			throw new Exception("apellido no valido");
		}
		if (cliente.getNombre() == null || cliente.getNombre().equals("") || cliente.getNombre().length() > 100) {
			throw new Exception("nombre no valido");
		}
		if (cliente.getTelefono1() == null || cliente.getTelefono1().equals("")
				|| cliente.getTelefono1().length() > 15) {
			throw new Exception("telefono1 no valido");
		}
		if (cliente.getTelefono2() == null || cliente.getTelefono2().equals("")
				|| cliente.getTelefono2().length() > 15) {
			throw new Exception("telefono2 no valido");
		}
		if (cliente.getCorreo() == null || cliente.getCorreo().equals("") || cliente.getCorreo().length() > 50) {
			throw new Exception("correo no valido");
		}
		if (cliente.getSexo() == null || cliente.getSexo().equals("") || cliente.getSexo().length() > 1) {
			throw new Exception("sexo no valido");
		}
		if (cliente.getFechaNacimiento() == null) {
			throw new Exception("fecha nacimiento no valida");
		}
		if (cliente.getFechaCreacion() == null) {
			throw new Exception("fecha creacion no valida");
		}
		if (cliente.getUsuCreador() == null || cliente.getUsuCreador().equals("")
				|| cliente.getUsuCreador().length() > 10) {
			throw new Exception("usuario creador no valido");
		}
		if (cliente.getEstado() == null || cliente.getEstado().equals("") || cliente.getEstado().length() > 1) {
			throw new Exception("estado no valido");
		}
		if (tipoIndetRepository.findById(cliente.getIdTiid().getIdTiid()) == null) {
			throw new Exception("tipo de identificacion no valido o no existe");
		}

		try {
			clienteRepository.save(cliente);
			System.out.println("cliente creado");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void actualizarCliente(Cliente cliente) throws Exception {
		if (clienteRepository.findById(cliente.getIdClie()) == null) {
			throw new Exception("cleinte no valido o no existe");
		} else {
			try {

				if (cliente.getIdClie() == null) {
					throw new Exception("debeingresar un id valido");
				}
				if (cliente.getNumeroIdentificacion() == null || cliente.getNumeroIdentificacion().equals("")
						|| cliente.getNumeroIdentificacion().length() > 15) {
					throw new Exception("numero identificacion no valido");
				}
				if (cliente.getPrimerApellido() == null || cliente.getPrimerApellido().equals("")
						|| cliente.getPrimerApellido().length() > 100) {
					throw new Exception("apellido no valido");
				}
				if (cliente.getSegundoApellido() == null || cliente.getSegundoApellido().equals("")
						|| cliente.getSegundoApellido().length() > 100) {
					throw new Exception("apellido no valido");
				}
				if (cliente.getNombre() == null || cliente.getNombre().equals("")
						|| cliente.getNombre().length() > 100) {
					throw new Exception("nombre no valido");
				}
				if (cliente.getTelefono1() == null || cliente.getTelefono1().equals("")
						|| cliente.getTelefono1().length() > 15) {
					throw new Exception("telefono1 no valido");
				}
				if (cliente.getTelefono2() == null || cliente.getTelefono2().equals("")
						|| cliente.getTelefono2().length() > 15) {
					throw new Exception("telefono2 no valido");
				}
				if (cliente.getCorreo() == null || cliente.getCorreo().equals("")
						|| cliente.getCorreo().length() > 50) {
					throw new Exception("correo no valido");
				}
				if (cliente.getSexo() == null || cliente.getSexo().equals("") || cliente.getSexo().length() > 1) {
					throw new Exception("sexo no valido");
				}
				if (cliente.getFechaNacimiento() == null) {
					throw new Exception("fecha nacimiento no valida");
				}
				if (cliente.getFechaModificacion() == null) {
					throw new Exception("fecha modificacion no valida");
				}
				if (cliente.getFechaCreacion() == null) {
					throw new Exception("fecha creacion no valida");
				}
				if (cliente.getUsuCreador() == null || cliente.getUsuCreador().equals("")
						|| cliente.getUsuCreador().length() > 10) {
					throw new Exception("usuario creador no valido");
				}
				if (cliente.getUsuModificador() == null || cliente.getUsuModificador().equals("")
						|| cliente.getUsuModificador().length() > 10) {
					throw new Exception("usuario Modificador no valido");
				}
				if (cliente.getEstado() == null || cliente.getEstado().equals("") || cliente.getEstado().length() > 1) {
					throw new Exception("estado no valido");
				}
				if (tipoIndetRepository.findById(cliente.getIdTiid().getIdTiid()) == null) {
					throw new Exception("tipo de identificacion no valido o no existe");
				}

				clienteRepository.save(cliente);
				System.out.println("cliente actualizado");

			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}

	}

	@Override
	public void eliminarCliente(int idCliente) throws Exception {
		if (clienteRepository.findById(idCliente) == null) {
			throw new Exception("cleinte no valido o no existe");
		} else {
			try {
				clienteRepository.deleteById(idCliente);
				System.out.println("cliente eliminado");
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}

		}

	}

	@Override
	public List<Cliente> consultarTodosClientes() throws Exception {
		List<Cliente> lisCli = clienteRepository.findAll();

		if (lisCli.isEmpty()) {
			throw new Exception("NO se encontraron clientes en el sistema");
		}

		return lisCli;
	}

	@Override
	public Cliente consultarClientePorId(Integer idCliente) throws Exception {
		try {
			Optional<Cliente> cliente = clienteRepository.findById(idCliente);
			if (cliente.isEmpty()) {
				throw new Exception("NO se encontraron clientes en el sistema");
			}
			return cliente.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
