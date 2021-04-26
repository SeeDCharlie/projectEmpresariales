package co.edu.usbcali.viajes.app;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import co.edu.usbcali.viajes.app.domain.Cliente;
import co.edu.usbcali.viajes.app.domain.Destino;
import co.edu.usbcali.viajes.app.domain.TipoDestino;
import co.edu.usbcali.viajes.app.domain.TipoIdentificacion;
import co.edu.usbcali.viajes.app.dto.ClienteDTO;
import co.edu.usbcali.viajes.app.dto.TipoDestinoDTO;
import co.edu.usbcali.viajes.app.repository.ClienteRepository;
import co.edu.usbcali.viajes.app.repository.DestinoRepository;
import co.edu.usbcali.viajes.app.repository.TipoDestinoRepository;
import co.edu.usbcali.viajes.app.repository.TipoIdentificacionRepository;
import co.edu.usbcali.viajes.app.repository.UsuarioRepository;
import co.edu.usbcali.viajes.app.service.ClienteServiceImpl;
import co.edu.usbcali.viajes.app.service.DestinoService;
import co.edu.usbcali.viajes.app.service.DestinoServiceImpl;
import co.edu.usbcali.viajes.app.service.TipoDestinoService;
import co.edu.usbcali.viajes.app.service.TipoIdentificacionService;
import co.edu.usbcali.viajes.app.service.TipoIdentificacionServiceImpl;
import co.edu.usbcali.viajes.app.utils.Constantes;

@SpringBootApplication
public class ViajesusbApplication implements CommandLineRunner {

	@Autowired
	private TipoIdentificacionRepository tipoIdentificacionRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private DestinoRepository destinoRespository;

	@Autowired
	private TipoDestinoRepository tipoDestinoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//servicios

	@Autowired
	private TipoDestinoService tipoDestinoService;
	
	@Autowired
	private DestinoServiceImpl destinoService;
	
	@Autowired
	private TipoIdentificacionServiceImpl tipoIndetService;
	
	@Autowired
	private ClienteServiceImpl clienteService;
//	MAIN
	public static void main(String[] args) {
		SpringApplication.run(ViajesusbApplication.class, args);
	}
	
	

//	run
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// CONSULTAR	
		//buscarTodosTipoDes();
		//consultarDestinoById(1);
		//consultarTodosTipoIdentificacion();
		//consultarPorIdTipoIden(8);
		//consultarTodosClientes();
		
		// GUARDAR
		//guardarTipoDestino();
		//guardarDestino();
		//guardarTipoIdentificacion();
		//guardarCliente();
		
		// ELIMINAR
		
		//eliminarTiDeById();
		//eliminarDestinoById(2);
		//eliminarTipoIden(8);
		//eliminarClientePorId(8);

		
		// ACTUALIZAR
		
		//actualizarTipoDestino();

		

	}

	/*------------------------------------------------------------------------------------------------------------------------------
	 * ------------------------------------------------ CRUD TIPO DE IDENTIFICACION ------------------------------------------------
	 */

	// CONSULTAR TODOS LOS TIPOS DE IDENTIFICACION ORDENADOS POR CODIGO
	private void consultarOrdenadosTipIdent() {
		List<TipoIdentificacion> lstTipoIdentificacion = tipoIdentificacionRepository.findAll(Sort.by("codigo"));

		if (lstTipoIdentificacion != null && !lstTipoIdentificacion.isEmpty()) {
			System.out.println("lista de tipos de identificacion:");
			for (TipoIdentificacion des : lstTipoIdentificacion) {
				System.out.println(des.getCodigo());
			}

		} else {
			System.out.println("lista de tipos de identificacion vacia");
		}
	}

	// CONSULTAR TIPO DE IDENTIFICACION POR ID
	private void consultarPorIdTipoIden(Integer id) {
		try {
			TipoIdentificacion td = tipoIndetService.consultarTipoIdentificacionById(id);
			System.out.println("tio de identificacion : " + td.getCodigo());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// CONSULTAR TODOS LOS TIPOS DE IDENTIFICACION
	public void consultarTodosTipoIdentificacion() {
		try {
			List<TipoIdentificacion> lisTipoIdentificacion = tipoIndetService.consultarTodosTipoIdentificacion();
			for (TipoIdentificacion td : lisTipoIdentificacion) {
				System.out.println("Id: " + td.getIdTiid() + " nombre: " + td.getNombre());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// GUARDAR UN TIPO DE IDENTIFICACION
	public void guardarTipoIdentificacion() {
		try {
			TipoIdentificacion tipoIdent = new TipoIdentificacion(7, "KK", "IDENTIFICACIONDOS", new Date(), new Date(), "seed",
					"seed", "c");
			tipoIndetService.guardarTipoIdentificacion(tipoIdent);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	// ACTUALIZAR TODOS LOS VALORES DE UN TIPO DE IDENTIFICACION POT ID
	public void actualizarTipoIdentificacion(int id, String codigo, String nombre, Date fechaaCreacion,
			String usuCreador, String usuModificador, String estado) {
		
		Optional<TipoIdentificacion> ti = tipoIdentificacionRepository.findById(id);
		
		if( ti.isPresent()) {
			TipoIdentificacion tipo = ti.get();
			tipo.setCodigo(codigo);
			tipo.setNombre(nombre);
			tipo.setFechaCreacion(fechaaCreacion);
			tipo.setUsuCreador(usuCreador);
			tipo.setUsuModificador(usuModificador);
			tipo.setEstado(estado);
		}else {
			System.out.println("el tipono existe");
		}
		
	}

	// ELIMINAR POR ID

	private void eliminarTipoIden(Integer idTd) {
		try {
			tipoIndetService.eliminarTipoIdentificacion(idTd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// ELIMINAR TODOS LOS TIPOS DE IDENTIFICACION
	private void eliminarAllTipoIden() {
		tipoIdentificacionRepository.deleteAll();
	}

	/*---------------------------------------------------------------------------------------------------------------
	 * ------------------------------------------------ CRUD CLIENTE ------------------------------------------------
	 */

	// CREAR CLIENTE
	public void guardarCliente() {
		TipoIdentificacion td = tipoIdentificacionRepository.findById(1).get();

		Cliente cli = new Cliente();
		cli.setIdTiid(td);
		cli.setIdClie(8);
		cli.setNumeroIdentificacion("666");
		cli.setPrimerApellido("guerrero");
		cli.setTelefono1("654313");
		cli.setTelefono2("684531");
		cli.setSegundoApellido("Martinez");
		cli.setCorreo("correo@cliente.com");
		cli.setNombre("jaime");
		cli.setSexo(Constantes.MASCULINO);
		cli.setFechaNacimiento(new Date());
		cli.setFechaCreacion(new Date());
		cli.setFechaModificacion(new Date());
		cli.setUsuModificador("seed");
		cli.setUsuCreador("seed");
		cli.setEstado(Constantes.ACTIVO);

		try {
			clienteService.guardarCliente(cli);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// CONSULTAR CLIENTE POR CODIGO DEL TIPO DE IDENTIFICACION

	public void consultarClientePorCodigoDeTipoIdentificacion(String tipo) {
		List<ClienteDTO> lstCli = clienteRepository.consultarClientePorCodigoDeTipoIdentificacion(tipo);

		if (lstCli != null && !lstCli.isEmpty()) {
			for (ClienteDTO cliente : lstCli) {
				System.out.println("Cliente nombre : " + cliente.getNombre() );
				//+ "\n NO IDENTIFICACION : " + cliente.getNumeroIdentificacion()
			}
		} else {

			System.out.println("no hay coincidencias o el tipo de identificacion no existe");
		}

	}

	// CONSULTAR CLIENTES POR NUMERO DE IDENTIFICACION USANDO LIKE

	public void consultaClientesNoIdentLike(String cadena) {

		List<Cliente> lstCliente = clienteRepository.findByNumeroIdentificacionLike("65");

		if (lstCliente != null && !lstCliente.isEmpty()) {
			for (Cliente cliente : lstCliente) {
				System.out.println(
						"cliente " + cliente.getNombre() + "\nno_identi : " + cliente.getNumeroIdentificacion());
			}
		} else {
			System.out.println("no hay coinsidencias");
		}
	}

	// ACTUALIZAR CLIENTE
	private void actualizarCliente() {

		Optional<Cliente> optional = clienteRepository.findById(1);

		if (optional.isPresent()) {
			Cliente cliente = optional.get();

			System.out.println("Cliente inicial: " + cliente.getNombre() + cliente.getPrimerApellido());

			cliente.setNombre("Alberto");
			cliente.setFechaModificacion(new Date());
			cliente.setUsuModificador("seed");

			clienteRepository.save(cliente);
			System.out.println("¡Cliente actualizado con exito!");
		} else {
			System.out.println("El cliente no existe");
		}

	}

	// LISTA LOS CLIENTES NACIDOS ENTRE DOS FECHAS

	public void findClienteByFechaCreacionBetween() {

		Calendar fechaInicio = new GregorianCalendar(2021, 0, 1);
		Calendar fechaFin = new GregorianCalendar();

		List<Cliente> lstClientes = clienteRepository.findByFechaNacimientoBetween(fechaInicio.getTime(),
				fechaFin.getTime());

		if (lstClientes != null && !lstClientes.isEmpty()) {
			for (Cliente cli : lstClientes) {
				System.out.println("Cliente nacidos entre fechas : " + cli.getNombre());
			}
		} else {
			System.out.println("No hay registros");
		}

	}

	// CONSULTAR CLIENTE POR NOMBRE USANDO LIKE

	public void buscarClientePorNombre(String nombre) {

		List<Cliente> lstClientes = clienteRepository.findByNombreLike(nombre);

		if (lstClientes != null && !lstClientes.isEmpty()) {
			for (Cliente cliente : lstClientes) {
				System.out.println("Cliente : " + cliente.getNombre());
			}

		} else {
			System.out.print("no hay coincidencias");
		}

	}

	// CONSULTAR CLIENTE POR ID

	public void consultarTodosClientes() {

		try {
			List<Cliente> listaClientes = clienteService.consultarTodosClientes();
			
			for (Cliente cli: listaClientes) {
				System.out.println("cliente " + cli.getIdClie() +" : " + cli.getNombre() + " " + cli.getPrimerApellido());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// CONSULTAR CLIENTES PAGINADO ORDENADO POR NOMBRE

	public void consultarClientePaginacion() {
		Page<Cliente> lstCliente = clienteRepository.findAll(PageRequest.of(0, 6, Sort.by("nombre")));

		if (lstCliente != null && !lstCliente.isEmpty()) {
			System.out.println("lista de clientes paginada (" + lstCliente.getTotalPages() + ") :");

			for (Cliente des : lstCliente) {
				System.out.println(des.getNumeroIdentificacion());
			}

		} else {
			System.out.println("lista de clientes vacia");
		}

	}

	// CONSULTAR CLIENTE ORDENADO POR NUMERO DE IDENTIFICACION

	private void consultarClienteOrdenadosIdent() {
		List<Cliente> lstClientes = clienteRepository.findAll(Sort.by("numeroIdentificacion"));

		if (lstClientes != null && !lstClientes.isEmpty()) {
			System.out.print("lista de Clientes :");
			for (Cliente des : lstClientes) {
				System.out.println(des.getNombre());
			}

		} else {
			System.out.println("lista de Clientes vacia");
		}
	}

	// CONSULTAR CLIENTE POR NUMERO DE IDENTIFICACION

	public void buscarClientePorNumIdent(String ident) {
		Cliente cli = clienteRepository.findByNumeroIdentificacion(ident);
		if (cli != null) {
			System.out.println(
					"Cliente : " + cli.getNombre() + "\nno. identificacion : " + cli.getNumeroIdentificacion());
		} else {
			System.out.println("No hay clientes con este numero de identificacion ");
		}
	}

	// CONSULTAR CLIENTE POR CORREO

	public void buscarClientePorCorreo(String correo) {
		Cliente cli = clienteRepository.findByCorreo(correo);
		if (cli != null) {
			System.out.println(
					"Cliente : " + cli.getNombre() + "\nno. identificacion : " + cli.getNumeroIdentificacion());
		} else {
			System.out.println("No hay clientes con este correo ");
		}
	}

	// CONSULTAR CLLIENTES POR ESTADO

	public void buscarClientePorEstado(String estado) {
		List<Cliente> lstClientes = clienteRepository.findByEstado(estado);

		if (lstClientes != null && !lstClientes.isEmpty()) {
			System.out.print("lista de Clientes por estado :");
			for (Cliente cli : lstClientes) {
				System.out.println("cliente : " + cli.getNombre());
			}

		} else {
			System.out.println("lista de Clientes vacia");
		}

	}

	// ELIMINAR CLIENTE POR ID
	public void eliminarClientePorId(Integer id) {
		try {
			clienteService.eliminarCliente(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// ELIMINAR TODOS LOS CLIENTES
	private void eliminarAllClientes() {
		clienteRepository.deleteAll();
	}

	/*--------------------------------------------------------------------------------------------------------------------
	 * ------------------------------------------------ CRUD TIPO DESTINO ------------------------------------------------
	 */
	// BUSCAR POR ID TIPO DESTINO


	// CONSULTAR TIPO DESTINO POR ESTADO

	private void consultarTipoDestinoPorEstado() {
		List<TipoDestinoDTO> lstTipoDest = tipoDestinoRepository.consultarTipoDestinoPorEstado(Constantes.ACTIVO);

		for (TipoDestinoDTO tipoDestino : lstTipoDest) {
			System.out.println(
					"Tipo Destino - ID : " + tipoDestino.getIdTide() + "\nNombre : " + tipoDestino.getNombre() + "\n-------------------------");
		}
	}

	// CONSULTAR TODOS LOS TIPOS DESTINO ORDENADOS POR CODIGO
	private void consultarTodosOrdenados() {
		List<TipoDestino> lstTipoDestino = tipoDestinoRepository.findAll(Sort.by("codigo"));

		if (lstTipoDestino != null && !lstTipoDestino.isEmpty()) {
			System.out.print("lista de tipos de destino:");
			for (TipoDestino des : lstTipoDestino) {
				System.out.println(des.getNombre());
			}
		} else {
			System.out.println("lista de destinos vacia");
		}
	}

	// CONSULTAR TODOS LOS TIPOS DESTINOS PAGINADOS ORDENADOS POR CODIGO
	public void consultarTiposDestinoPaginacion() {
		Page<TipoDestino> lstTiposDestino = tipoDestinoRepository.findAll(PageRequest.of(0, 8, Sort.by("codigo")));

		if (lstTiposDestino != null && !lstTiposDestino.isEmpty()) {
			System.out.println("lista de tipos de destino paginada (" + lstTiposDestino.getTotalPages() + ") :");

			for (TipoDestino des : lstTiposDestino) {
				System.out.println(des.getCodigo());
			}

		} else {
			System.out.println("lista de destinos vacia");
		}

	}

	// LISTAR TODOS LOS TIPOS DESTINO
	private void buscarTodosTipoDes() {
		
		List<TipoDestino> lstTd = null;
		
		try {
			lstTd = tipoDestinoService.consultarTiposDestino();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (TipoDestino tipoDestino : lstTd) {
			System.out.println("tipo destino : " + tipoDestino.getNombre());
		}
		
	}

	// CONTAR CANTIDAD DE REGISTROS

	private void contarTipoDestino() {

		Long num = tipoIdentificacionRepository.count();
		System.out.println("numero de tipos de destino : " + num);
	}

	// ENCUENTRA UN TIPO DESTINO ENTRE DOS FECHAS

	public void findByFechaCreacionBetween() {

		Calendar fechaInicio = new GregorianCalendar(2021, 0, 1);
		Calendar fechaFin = new GregorianCalendar();

		List<TipoDestino> lstTipoDestino = tipoDestinoRepository.findByFechaCreacionBetween(fechaInicio.getTime(),
				fechaFin.getTime());

		for (TipoDestino td : lstTipoDestino) {
			System.out.println("tipo destinos entre fechas : " + td.getNombre());
		}
	}
	
	public void eliminarTodosTipoDestino() {
		tipoDestinoRepository.deleteAll();
	}
	
	public void eliminarTiDeById() {
		
		try {
			tipoDestinoService.eliminarTipoDestino(8);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void guardarTipoDestino() {
		Calendar fecha = new GregorianCalendar(2021, 0, 1);
		TipoDestino tipoDes = new TipoDestino(10, "mar", "acapulco_dos", "descripcion", fecha.getTime() ,fecha.getTime(), "CLOPEZ", "CLOPEZ", "A");
		
		try {
			tipoDestinoService.guardarTipoDestino(tipoDes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void actualizarTipoDestino() {
		Calendar fecha = new GregorianCalendar(2021, 0, 1);
		TipoDestino tipoDes = new TipoDestino(10, "mar", "acapulco_dos", "descripcion actualizada", fecha.getTime() ,fecha.getTime(), "CLOPEZ", "CLOPEZ", "A");
		try {
			tipoDestinoService.actualizarTipoDestino(tipoDes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*---------------------------------------------------------------------------------------------------------------------------
	 * ----------------------------------------- CRUD DESTINO -------------------------------------------------------------------
	 */

	// CONSULTAR TODOS LOS DESTINOS

	private void consultarDestinos() {
		List<Destino> listDestino = destinoRespository.findAll();

		if (listDestino != null && !listDestino.isEmpty()) {
			System.out.print("lista de destinos");
			for (Destino des : listDestino) {
				System.out.println(des);
			}

		} else {
			System.out.println("lista de destinos vacia");
		}
	}
	// AGRAGAR UN DESTINO

	public void guardarDestino() {
		Calendar fecha = new GregorianCalendar(2021, 0, 1);
		Optional<TipoDestino> td = tipoDestinoRepository.findById(2);
		Destino destino = new Destino(2, "acps", "acpN", "DESCRIPCION", Constantes.SI, Constantes.SI, Constantes.SI,
				fecha.getTime(), fecha.getTime(), "seed", "seed", "c", td.get());
		
		try {
			destinoService.guardarDestino(destino);
			System.out.println("destino guardado : " + destino.getNombre());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	

	}
	
	public void consultarDestinoById(int idDest){
		try {
			Destino destino = destinoService.consultarDestino(idDest);
			System.out.println("destino :" + destino.getNombre());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// ELIMINAR TODOS LOS DESTINOS
	
	public void eliminarDestinoById(int idDest) {
		
		try {
			destinoService.eliminarDestino(idDest);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void eliminarTodosDestino() {
		destinoRespository.deleteAll();
	}

	public void consultarDestinoTipoDestino() {
		List<Destino> lstDestino = destinoRespository.findByTipoDestino_codigo("c");
		System.out.println("tipos destino porcodigo :");
		for (Destino destino : lstDestino) {
			System.out.println(destino.getNombre());
		}
	}

}
