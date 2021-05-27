package co.edu.usbcali.viajes.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.usbcali.viajes.app.domain.Destino;
import co.edu.usbcali.viajes.app.dto.DestinoDTO;

@Mapper(componentModel = "spring")
public interface DestinoMapper {

	@Mapping(source = "tipoDestino.idTide",target = "tipoDestinoId")
	@Mapping(source = "tipoDestino.codigo",target = "tipoDestinoCodigo")
	public DestinoDTO destinoToDestinoDTO(Destino destino);
	
	
	@Mapping(source = "tipoDestinoId",target = "tipoDestino.idTide")
	@Mapping(source = "tipoDestinoCodigo",target = "tipoDestino.codigo")
	public Destino destinoDTOToDestino(DestinoDTO destino);
}
