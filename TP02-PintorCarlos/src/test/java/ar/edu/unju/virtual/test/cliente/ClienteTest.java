package ar.edu.unju.virtual.test.cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.edu.unju.virtual.TP02PintorCarlos.Tp02PintorCarlosApplication;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cliente;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cuenta;
import ar.edu.unju.virtual.TP02PintorCarlos.model.service.ClienteService;
import ar.edu.unju.virtual.TP02PintorCarlos.model.service.CuentaService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Tp02PintorCarlosApplication.class)
public class ClienteTest {
	Cliente cliente;
	Cuenta cuenta;

  @Autowired
  private ClienteService service;
  
  @Autowired
  private CuentaService cuentaService;
	
  @Before
  public void before_tests() {
  	cliente = new Cliente(
      12345678L,
      "john.doe",
      "j0hn.d03",
      "John Doe",
      "120 Redberry Road",
      "john.doe@hotmail.com",
      "HABILITADO"
    );  	
  }
  
	private Timestamp getTimestamp(String dateString) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;
    Timestamp tstamp = null;
    
		try {
			date = df.parse(dateString);
			tstamp = new java.sql.Timestamp(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace(); 
		}
    
    return tstamp;
	}

	@Test
	public void test() {
		service.create(cliente);
		
		// Abrir cuenta.
		Cuenta cuenta1 = createCuenta (new Cuenta(
  		"11111111111111111111",
  		getTimestamp("2019-01-01"),
  		50000d,
  		"HABILITADO",
  		5000l,
  		cliente
  	));
		
		assertNotNull(cuenta1);		
		
		assertEquals(1, cliente.getCuentas().size());
	}

	private Cuenta createCuenta(Cuenta cuenta) {
		return cuentaService.create(cuenta);
	}

}
