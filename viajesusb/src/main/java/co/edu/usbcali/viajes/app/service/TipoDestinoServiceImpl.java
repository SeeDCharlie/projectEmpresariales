package co.edu.usbcali.viajes.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajes.app.domain.TipoDestino;
import co.edu.usbcali.viajes.app.domain.TipoIdentificacion;
import co.edu.usbcali.viajes.app.repository.TipoDestinoRepository;
import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class TipoDestinoServiceImpl implements TipoDestinoService {

	@Autowired
	private TipoDestinoRepository tipoDestinoRepository;

	@Override
	public void guardarTipoDestino(TipoDestino tipoDestino) throws Exception {

		if (tipoDestino == null) {
			throw new Exception("tipo destino no valido");
		}
		if (tipoDestino.getCodigo() == null || tipoDestino.getCodigo().equals("")
				|| tipoDestino.getCodigo().length() > 5) {
			throw new Exception("debe ingresar un codigo valido");
		}
		if (tipoDestino.getNombre() == null || tipoDestino.getNombre().equals("")
				|| tipoDestino.getNombre().length() > 100) {
			throw new Exception("debe ingresar un nombre valido");
		}
		if (tipoDestino.getDescripcion() == null || tipoDestino.getDescripcion().equals("")
				|| tipoDestino.getDescripcion().length() > 300) {
			throw new Exception("debe ingresar una descripcion valida");
		}
		if (tipoDestino.getFechaCreacion() == null) {
			throw new Exception("debe ingresar una fecha de creacion valida");
		}
		/*
		 * if(tipoDestino.getFechaModificacion() == null) { throw new
		 * Exception("debe ingresar una fecha de modificacion valida"); }
		 */
		if (tipoDestino.getUsuCreador() == null) {
			throw new Exception("debe ingresar un usuario creador valido");
		}
		/*
		 * if(tipoDestino.getUsuModificador().equals("") ||
		 * tipoDestino.getUsuModificador().length() > 10) { throw new
		 * Exception("debe ingresar un usuario modificador valido" ); }
		 */

		if (tipoDestino.getEstado() == null || tipoDestino.getEstado().equals("")
				|| tipoDestino.getEstado().length() > 1) {
			throw new Exception("debe ingresar un estado valido");
		} else {
			try {
				tipoDestinoRepository.save(tipoDestino);
				System.out.println("tipo destino guardado");
				
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}

		}
	}

	@Override
	public List<TipoDestino> consultarTiposDestino() throws Exception {

		List<TipoDestino> lisTd = tipoDestinoRepository.findAll();

		if (lisTd.isEmpty()) {
			throw new Exception("NO se encontraron tipos de destino en el sistema");
		}

		return lisTd;
	}

	@Override
	public void eliminarTipoDestino(int idTd) throws Exception {
		if (tipoDestinoRepository.findById(idTd) == null) {
			throw new Exception("debe ingresar un id valido");
		} else {
			try {
				tipoDestinoRepository.deleteById(idTd);
				System.out.print("tipo destino eliminado");
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
	}

	@Override
	public void actualizarTipoDestino(TipoDestino tipoDestino) throws Exception {

		if (tipoDestinoRepository.findById(tipoDestino.getIdTide()) == null) {
			throw new Exception("debe ingresar un tipo destino valido");
		} else {
			try {
				if (tipoDestino == null) {
					throw new Exception("tipo destino no valido");
				}
				if (tipoDestino.getCodigo() == null || tipoDestino.getCodigo().equals("")
						|| tipoDestino.getCodigo().length() > 5) {
					throw new Exception("debe ingresar un codigo valido");
				}
				if (tipoDestino.getNombre() == null || tipoDestino.getNombre().equals("")
						|| tipoDestino.getNombre().length() > 100) {
					throw new Exception("debe ingresar un nombre valido");
				}
				if (tipoDestino.getDescripcion() == null || tipoDestino.getDescripcion().equals("")
						|| tipoDestino.getDescripcion().length() > 300) {
					throw new Exception("debe ingresar una descripcion valida");
				}
				if (tipoDestino.getFechaCreacion() == null) {
					throw new Exception("debe ingresar una fecha de creacion valida");
				}

				if (tipoDestino.getFechaModificacion() == null) {
					throw new Exception("debe ingresar una fecha de modificacion valida");
				}

				if (tipoDestino.getUsuCreador() == null) {
					throw new Exception("debe ingresar un usuario creador valido");
				}

				if (tipoDestino.getUsuModificador().equals("") || tipoDestino.getUsuModificador().length() > 10) {
					throw new Exception("debe ingresar un usuario modificador valido");
				}

				if (tipoDestino.getEstado() == null || tipoDestino.getEstado().equals("")
						|| tipoDestino.getEstado().length() > 1) {
					throw new Exception("debe ingresar un estado valido");
				} else {

					tipoDestinoRepository.save(tipoDestino);
					System.out.print("tipo destino actualizado");

				}
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}

	}

	@Override
	public TipoDestino consultarTipoDestinoPorId(int id) throws Exception {

		try {
			Optional<TipoDestino> td = tipoDestinoRepository.findById(id);
			if (td != null) {
				return td.get();
			} else {
				throw new Exception("debe ingresar un id valido o no existe el tipo destino");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public TipoDestino consultarTiposDestinoPorCodigo(String codigo) throws Exception {
		try {
			TipoDestino td = tipoDestinoRepository.findByCodigo(codigo);
			if (td != null) {
				return td;
			} else {
				throw new Exception("debe ingresar un codigo valido o no existe el tipo destino");
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
