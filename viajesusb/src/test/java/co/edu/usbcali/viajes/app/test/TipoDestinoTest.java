package co.edu.usbcali.viajes.app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.edu.usbcali.viajes.app.domain.TipoDestino;
import co.edu.usbcali.viajes.app.dto.TipoDestinoDTO;
import co.edu.usbcali.viajes.app.mapper.TipoDestinoMapper;

@SpringBootTest
public class TipoDestinoTest {
	
	private final static Logger log = LoggerFactory.getLogger(TipoDestinoTest.class);
	
	@Autowired
	private TipoDestinoMapper tipoDestinoMapper;
	
	@Test
	void debeMapearTipoDestinoToTipoDestinoDTO() {
		
		//Arrange
		TipoDestino tipoDestino = new TipoDestino();
		tipoDestino.setCodigo("TEST");
		tipoDestino.setDescripcion("PRUEBA MAP");
		tipoDestino.setEstado("A");
		tipoDestino.setFechaCreacion(new Date());
		tipoDestino.setIdTide(2);
		tipoDestino.setNombre("MAPSTRUCT");
		tipoDestino.setUsuCreador("CLOPEZ"); 
		//Act
		
		TipoDestinoDTO tipoDestinoDTO = tipoDestinoMapper.tipoDestinoToTipoDestinoDTO(tipoDestino);
		log.info(tipoDestinoDTO.toString());
		//Assert
		
		assertEquals(tipoDestino.getCodigo(), tipoDestinoDTO.getCodigo());
		assertEquals(tipoDestino.getNombre(), tipoDestinoDTO.getNombre());
	}
	
	@Test
	void debeMapearListaTipoDestinoToListaTipoDestinoDTO() {
		
		List<TipoDestino> listTipoDestino = new ArrayList<>();
		List<TipoDestinoDTO> listTipoDestinoDTO = new ArrayList<>();
		
		//Arrange
		TipoDestino tipoDestino = new TipoDestino();
		tipoDestino.setCodigo("TEST");
		tipoDestino.setDescripcion("PRUEBA MAP");
		tipoDestino.setEstado("A");
		tipoDestino.setFechaCreacion(new Date());
		tipoDestino.setIdTide(2);
		tipoDestino.setNombre("MAPSTRUCT");
		tipoDestino.setUsuCreador("CLOPEZ"); 
		
		TipoDestino tipoDestino2 = new TipoDestino();
		tipoDestino2.setCodigo("TEST");
		tipoDestino2.setDescripcion("PRUEBA MAP");
		tipoDestino2.setEstado("A");
		tipoDestino2.setFechaCreacion(new Date());
		tipoDestino2.setIdTide(2);
		tipoDestino2.setNombre("MAPSTRUCT");
		tipoDestino2.setUsuCreador("CLOPEZ"); 
		
		listTipoDestino.add(tipoDestino);
		listTipoDestino.add(tipoDestino2);
		//Act
		
		listTipoDestinoDTO = tipoDestinoMapper.listTipoDestinoToListTipoDestinoDTO(listTipoDestino);
		/*log.info(tipoDestinoDTO.toString());
		//Assert
		
		assertEquals(tipoDestino.getCodigo(), tipoDestinoDTO.getCodigo());
		assertEquals(tipoDestino.getNombre(), tipoDestinoDTO.getNombre());*/
	}

}
