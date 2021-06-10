package co.edu.usbcali.viajes.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajes.app.domain.Cliente;
import co.edu.usbcali.viajes.app.domain.TipoIdentificacion;
import co.edu.usbcali.viajes.app.dto.ClienteDTO;
import co.edu.usbcali.viajes.app.service.ClienteServiceImpl;
import co.edu.usbcali.viajes.app.service.TipoIdentificacionServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/cliente")
public class ClienteRestController {
	


		@Autowired
		private ClienteServiceImpl clienteService;
		
		@Autowired
		private TipoIdentificacionServiceImpl tipoIdentificacionService;

		@GetMapping("/getClientes")
		public ResponseEntity<?> buscarTodosCliente() {

			try {
				return ResponseEntity.ok().body(clienteService.consultarTodosClientes());
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			}
		}

		@GetMapping("/getClientePorId")
		public ResponseEntity<?> buscarClientePorId(@RequestParam("idCliente") Integer id) {

			try {
				return ResponseEntity.ok().body(clienteService.consultarClientePorId(id));
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			}
		}
		
		@PostMapping("/guardarCliente")
		public ResponseEntity<?> guardarCliente(@RequestBody ClienteDTO cliente) {

			try {
				TipoIdentificacion ti = tipoIdentificacionService.consultarTipoIdentificacionById(cliente.getTipoIdentificacion());
				
				Cliente cli = new Cliente(null, cliente.getNumeroIdentificacion(), cliente.getPrimerApellido(), 
						cliente.getSegundoApellido(),cliente.getNombre(), cliente.getTelefono1(), cliente.getTelefono2(),
						cliente.getCorreo(), cliente.getSexo(), cliente.getFechaNacimiento(),
						cliente.getFechaCreacion(), null, cliente.getUsuCreador(), null, cliente.getEstado(), ti );
				
				clienteService.guardarCliente(cli);
				return ResponseEntity.ok().body(cliente);
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			}
		}
		
		@PutMapping("/actualizarCliente")
		public ResponseEntity<?> actualizarCliente(@RequestBody ClienteDTO cliente) {

			try {
				TipoIdentificacion ti = tipoIdentificacionService.consultarTipoIdentificacionById(cliente.getTipoIdentificacion());
				
				Cliente cli = new Cliente(cliente.getIdClie(), cliente.getNumeroIdentificacion(), cliente.getPrimerApellido(), 
						cliente.getSegundoApellido(),cliente.getNombre(), cliente.getTelefono1(), cliente.getTelefono2(),
						cliente.getCorreo(), cliente.getSexo(), cliente.getFechaNacimiento(),
						cliente.getFechaCreacion(), cliente.getFechaModificacion(), cliente.getUsuCreador(), cliente.getUsuModificador(), cliente.getEstado(), ti );
				
				clienteService.actualizarCliente(cli);
				return ResponseEntity.ok().body(cliente);
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			}
		}
		
		@DeleteMapping("/eliminarClientePorId")
		public ResponseEntity<?> eliminarClientePorId(@RequestParam("idCliente") Integer idCli) {

			try {
				clienteService.eliminarCliente(idCli);
				Map<String, String> dats = new HashMap<>();
				dats.put("mensaje", "Cliente eliminado : " + idCli );
				return ResponseEntity.ok().body(dats);
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			}
		}
		
		
	

}
