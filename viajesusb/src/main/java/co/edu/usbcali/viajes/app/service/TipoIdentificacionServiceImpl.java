package co.edu.usbcali.viajes.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajes.app.domain.TipoDestino;
import co.edu.usbcali.viajes.app.domain.TipoIdentificacion;
import co.edu.usbcali.viajes.app.repository.TipoIdentificacionRepository;

@Service
public class TipoIdentificacionServiceImpl implements TipoIdentificacionService {

	@Autowired
	private TipoIdentificacionRepository tipoIdentificacionRepository;

	@Override
	public void guardarTipoIdentificacion(TipoIdentificacion tipoIdentificacion) throws Exception {

		if (tipoIdentificacion == null) {
			throw new Exception("el tipo de indentificacion no es valido");
		}
		
		if (tipoIdentificacion.getCodigo() == null || tipoIdentificacion.getCodigo().equals("")
				|| tipoIdentificacion.getCodigo().length() > 5) {
			throw new Exception("codigo no valido");
		}
		if (tipoIdentificacion.getNombre().equals("") || tipoIdentificacion.getNombre() == null
				|| tipoIdentificacion.getNombre().length() > 100) {
			throw new Exception("Nombre no valido");
		}
		if (tipoIdentificacion.getFechaCreacion() == null || tipoIdentificacion.getFechaCreacion().equals("")) {
			throw new Exception("FechaCreacion no valido");
		}
		if (tipoIdentificacion.getUsuCreador() == null || tipoIdentificacion.getUsuCreador().equals("")
				|| tipoIdentificacion.getUsuCreador().length() > 10) {
			throw new Exception("UsuCreador no valido");
		}
		if (tipoIdentificacion.getEstado() == null || tipoIdentificacion.getEstado().equals("")
				|| tipoIdentificacion.getEstado().length() > 1) {
			throw new Exception("Estado no valido");
		}
		try {
			tipoIdentificacionRepository.save(tipoIdentificacion);
			System.out.println("tipo identificacion guardado");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void actualizarTipoIdentificacion(TipoIdentificacion tipoIdentificacion) throws Exception {
		try {
			if (tipoIdentificacion == null
					|| tipoIdentificacionRepository.findById(tipoIdentificacion.getIdTiid()) == null) {
				throw new Exception("el tipo de indentificacion no es valido");
			} else {

				if (tipoIdentificacion.getIdTiid() == null) {
					throw new Exception("id no es valido o ya existe");
				}
				if (tipoIdentificacion.getCodigo() == null || tipoIdentificacion.getCodigo().equals("")
						|| tipoIdentificacion.getCodigo().length() > 5) {
					throw new Exception("codigo no valido");
				}
				if (tipoIdentificacion.getNombre().equals("") || tipoIdentificacion.getNombre() == null
						|| tipoIdentificacion.getNombre().length() > 100) {
					throw new Exception("Nombre no valido");
				}
				if (tipoIdentificacion.getFechaCreacion() == null || tipoIdentificacion.getFechaCreacion().equals("")) {
					throw new Exception("FechaCreacion no valido");
				}
				if (tipoIdentificacion.getFechaModificacion() == null
						|| tipoIdentificacion.getFechaModificacion().equals("")) {
					throw new Exception("FechaModificacion no valido");
				}
				if (tipoIdentificacion.getUsuCreador() == null || tipoIdentificacion.getUsuCreador().equals("")
						|| tipoIdentificacion.getUsuCreador().length() > 10) {
					throw new Exception("UsuCreador no valido");
				}
				if (tipoIdentificacion.getUsuModificador() == null || tipoIdentificacion.getUsuModificador().equals("")
						|| tipoIdentificacion.getUsuModificador().length() > 10) {
					throw new Exception("UsuModificador no valido");
				}
				if (tipoIdentificacion.getEstado() == null || tipoIdentificacion.getEstado().equals("")
						|| tipoIdentificacion.getEstado().length() > 1) {
					throw new Exception("Estado no valido");
				}
				try {
					tipoIdentificacionRepository.save(tipoIdentificacion);
					System.out.println("tipo identificacion actualizado");
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	@Override
	public List<TipoIdentificacion> consultarTodosTipoIdentificacion() throws Exception {
		List<TipoIdentificacion> lisTd = tipoIdentificacionRepository.findAll();
		if (lisTd.isEmpty()) {
			throw new Exception("NO se encontraron tipos de identificacion en el sistema");
		}
		return lisTd;
	}

	@Override
	public void eliminarTipoIdentificacion(int idTipoIdentificacion) throws Exception {

		if (tipoIdentificacionRepository.findById(idTipoIdentificacion) == null) {
			throw new Exception("TipoIdentificacion no valido o no existe");
		} else {
			try {
				tipoIdentificacionRepository.deleteById(idTipoIdentificacion);
				System.out.print("tipo identificacion eliminado");
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
	}

	@Override
	public TipoIdentificacion consultarTipoIdentificacionById(int idTiid) throws Exception {

		try {
			Optional<TipoIdentificacion> tipoIdent = tipoIdentificacionRepository.findById(idTiid);

			if (tipoIdent == null) {
				throw new Exception("TipoIdentificacion no valido o no existe");
			}

			return tipoIdent.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

}
