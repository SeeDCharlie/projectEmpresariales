package co.edu.usbcali.viajes.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import co.edu.usbcali.viajes.app.domain.Destino;
import co.edu.usbcali.viajes.app.repository.DestinoRepository;
import co.edu.usbcali.viajes.app.repository.TipoDestinoRepository;

@Service
public class DestinoServiceImpl implements DestinoService {

	@Autowired
	private DestinoRepository destinoRepository;
	@Autowired
	private TipoDestinoRepository tipoDestinoRepository;

	@Override
	public void guardarDestino(Destino destino) throws Exception {

		if (destino == null) {
			throw new Exception("Debe ingresar un destino");
		}
		if (destino.getCodigo() == null || destino.getCodigo().equals("") || destino.getCodigo().length() > 5) {
			throw new Exception("Debe ingresar un codigo de destino valido");
		}
		if (destino.getNombre().equals("") || destino.getNombre() == null || destino.getNombre().length() > 100) {
			throw new Exception("Debe ingresar un nombre de destino valido");
		}
		if (destino.getDescripcion().equals("") || destino.getDescripcion() == null
				|| destino.getDescripcion().length() > 300) {
			throw new Exception("Debe ingresar una descripcion de destino valido");
		}
		if (destino.getTierra().equals("") || destino.getTierra() == null || destino.getTierra().length() > 1) {
			throw new Exception("Debe decir si hay tierra en el destino");
		}
		if (destino.getAire().equals("") || destino.getAire() == null || destino.getAire().length() > 1) {
			throw new Exception("Debe decir si hay aire en el destino");
		}
		if (destino.getMar().equals("") || destino.getMar() == null || destino.getMar().length() > 1) {
			throw new Exception("Debe decir si hay mar en el destino");
		}
		if (destino.getFechaCreacion() == null || destino.getFechaModificacion() == null) {
			throw new Exception("Debe ingresar una fecha de creacion y ultima modificacion para el destino");
		}
		if (destino.getUsuCreador() == null || destino.getUsuCreador().equals("")
				|| destino.getUsuCreador().length() > 10) {
			throw new Exception("Debe ingresar un usuario creador valido para el destino");
		}

		if (destino.getEstado() == null || destino.getEstado().equals("") || destino.getEstado().length() > 1) {
			throw new Exception("Debe ingresar un estado valido para el destino");
		}
		if (tipoDestinoRepository.findById(destino.getTipoDestino().getIdTide()) == null) {
			throw new Exception("Debe ingresar un tipo de destino valido para el destino");
		} else {
			try {
				destinoRepository.save(destino);
				System.out.print("destino guardado : " + destino.getNombre());
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}

	}

	@Override
	public void eliminarDestino(int destino) throws Exception {
		if (destinoRepository.findById(destino) == null) {
			throw new Exception("Debe ingresar un destino valido o no existe el destino");
		} else {
			try {
				destinoRepository.deleteById(destino);
				System.out.print("destino eliminado");
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}

	}

	@Override
	public void actualizarDestino(Destino destino) throws Exception {
		try {

			if (destino == null || destinoRepository.findById(destino.getIdDest()) == null) {
				throw new Exception("Destino no valido");
			} else {

				if (destino.getCodigo() == null || destino.getCodigo().equals("") || destino.getCodigo().length() > 5) {
					throw new Exception("Debe ingresar un codigo de destino valido");
				}
				if (destino.getNombre().equals("") || destino.getNombre() == null
						|| destino.getNombre().length() > 100) {
					throw new Exception("Debe ingresar un nombre de destino valido");
				}
				if (destino.getDescripcion().equals("") || destino.getDescripcion() == null
						|| destino.getDescripcion().length() > 300) {
					throw new Exception("Debe ingresar una descripcion de destino valido");
				}
				if (destino.getTierra().equals("") || destino.getTierra() == null || destino.getTierra().length() > 1) {
					throw new Exception("Debe decir si hay tierra en el destino");
				}
				if (destino.getAire().equals("") || destino.getAire() == null || destino.getAire().length() > 1) {
					throw new Exception("Debe decir si hay aire en el destino");
				}
				if (destino.getMar().equals("") || destino.getMar() == null || destino.getMar().length() > 1) {
					throw new Exception("Debe decir si hay mar en el destino");
				}
				if (destino.getFechaCreacion() == null) {
					throw new Exception("Debe ingresar una fecha de creacion para el destino");
				}
				if (destino.getFechaModificacion() == null) {
					throw new Exception("Debe ingresar una fecha de ultima modificacion para el destino");
				}
				if (destino.getUsuCreador() == null || destino.getUsuCreador().equals("")
						|| destino.getUsuCreador().length() > 10) {
					throw new Exception("Debe ingresar un usuario creador valido para el destino");
				}
				if (destino.getUsuModificador().equals("") || destino.getUsuModificador().length() > 10) {
					throw new Exception("Debe ingresar un usuario modificador valido para el destino");
				}
				if (destino.getEstado() == null || destino.getEstado().equals("") || destino.getEstado().length() > 1) {
					throw new Exception("Debe ingresar un estado valido para el destino");
				}
				if (tipoDestinoRepository.findById(destino.getTipoDestino().getIdTide()) == null) {
					throw new Exception("Debe ingresar un tipo de destino valido para el destino");
				}

				destinoRepository.save(destino);
				System.out.print("destino guardado : " + destino.getNombre());
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Destino consultarDestino(int idDestino) throws Exception {

		Optional<Destino> destino = destinoRepository.findById(idDestino);

		if (destino == null) {
			throw new Exception("Debe ingresar un id valido para el destino");
		} else {
			try {
				return destino.get();
			} catch (Exception e) {
				throw new Exception("El destino no existe");
			}

		}
	}

	@Override
	public List<Destino> consultarTodosDestinos() throws Exception {
		try {
			List<Destino> listaDestinos = destinoRepository.findAll();

			if (listaDestinos.isEmpty()) {
				throw new Exception("lista de destinos vacia");
			}
			return listaDestinos;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

}
