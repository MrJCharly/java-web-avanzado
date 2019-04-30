package ar.edu.unju.virtual.test.cliente;

import static org.junit.Assert.assertEquals;

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
import ar.edu.unju.virtual.test.Util;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Tp02PintorCarlosApplication.class)
public class ClienteTest {
	Cliente cliente;
	Cuenta cuenta;

  @Autowired
  private ClienteService clienteService;
  
  @Autowired
  private CuentaService cuentaService;
	
  @Before
  public void before_tests() {
  	cliente = Util.getCliente();
  	cuenta = Util.getCuenta(cliente);
  }  	

	@Test
	public void testGetCuentas() {
		// Crear cliente.
	  clienteService.create(cliente);
		
		// Abrir cuenta y asignar titular.
		cuentaService.create(cuenta);
					
		// Recuperar cliente con sus cuentas.
		cliente = clienteService.findById(cliente.getId()); 
		
		// Verificar que cuenta1 fue asignada al cliente.
		assertEquals(1, cliente.getCuentas().size());
		assertEquals(cuenta.getId(), cliente.getCuentas().get(0).getId());
		
		// Restablecer BBDD.
		// Al utilizar cascade=CascadeType.ALL basta con eliminar cliente para
		// eliminar también las cuentas asociadas.
		clienteService.delete(cliente);
	}		

}
