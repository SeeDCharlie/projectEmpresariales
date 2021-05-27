package co.edu.usbcali.viajes.app.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.usbcali.viajes.app.domain.TipoDestino;
import co.edu.usbcali.viajes.app.dto.TipoDestinoDTO;

@Mapper(componentModel = "spring")
public interface TipoDestinoMapper {

	
	public TipoDestinoDTO tipoDestinoToTipoDestinoDTO(TipoDestino tipoDestino);
	public TipoDestino tipoDestinoDTOToTipoDestino(TipoDestinoDTO tipoDestinoDTO);
	
	public List<TipoDestinoDTO> listTipoDestinoToListTipoDestinoDTO(List<TipoDestino> listTipoDestino);
	public List<TipoDestino> listTipoDestinoDTOToListTipoDestino(List<TipoDestinoDTO> listTipoDestinoDTO);
}
