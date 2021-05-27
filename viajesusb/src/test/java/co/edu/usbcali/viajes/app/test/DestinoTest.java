package co.edu.usbcali.viajes.app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.edu.usbcali.viajes.app.domain.Destino;
import co.edu.usbcali.viajes.app.domain.TipoDestino;
import co.edu.usbcali.viajes.app.dto.DestinoDTO;
import co.edu.usbcali.viajes.app.mapper.DestinoMapper;
import co.edu.usbcali.viajes.app.utils.Constantes;


@SpringBootTest
public class DestinoTest {
	
	@Autowired
	private DestinoMapper destinoMapper;
	
	
	private final static Logger log = LoggerFactory.getLogger(DestinoTest.class);
	
	@Test
	void debeMapearDestinoDTOToDestino() {
		
		
		//Arrange
		//Se arma el objeto tipo destino
		TipoDestino tipoDestino = new TipoDestino();
		tipoDestino.setCodigo("TEST");
		tipoDestino.setDescripcion("PRUEBA MAP");
		tipoDestino.setEstado("A");
		tipoDestino.setFechaCreacion(new Date());
		tipoDestino.setIdTide(2);
		tipoDestino.setNombre("MAPSTRUCT");
		tipoDestino.setUsuCreador("CLOPEZ");

		//Se crea el destino
		Destino destino = new Destino();
		destino.setAire(Constantes.SI);
		destino.setMar(Constantes.SI);
		destino.setTierra(Constantes.NO);
		destino.setCodigo("EJEMP");
		destino.setDescripcion("SITIO TURISTICO DE EJEMPLO");
		destino.setEstado(Constantes.ACTIVO);
		destino.setFechaCreacion(new Date());
		destino.setNombre("EJEMPLO");
		destino.setTipoDestino(tipoDestino);
		destino.setUsuCreador("CLOPEZ");
		destino.setTipoDestino(tipoDestino); 
		
		//Act
		DestinoDTO destinoDTO = destinoMapper.destinoToDestinoDTO(destino);
		
		log.info(destinoDTO.toString());
		
		//Assert
		assertEquals(tipoDestino.getCodigo(), destinoDTO.getTipoDestinoCodigo());
	}
}
