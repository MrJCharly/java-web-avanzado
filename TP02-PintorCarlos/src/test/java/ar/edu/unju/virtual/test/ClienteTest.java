package ar.edu.unju.virtual.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
  private ClienteService clienteService;
  
  @Autowired
  private CuentaService cuentaService;
	
  @Before
  public void before_tests() {    
  	cliente = Util.getCliente(null);
  	cuenta = Util.getCuenta(cliente);
  }  	

  @Test
  public void testCreateAndRetrieve() {    
    // Crear cliente.
    clienteService.create(cliente);
    
    // Recuperar cliente.
    cliente = clienteService.findById(cliente.getId());
    
    assertNotNull(cliente);
    
    clienteService.delete(cliente);
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

	@Test
	public void testUpdate() {
	  // Crear cliente.
    clienteService.create(cliente);
    
    cliente.setNombre("Juan Pérez");
    
    clienteService.update(cliente);
    
    // Recuperar cliente.
    cliente = clienteService.findById(cliente.getId());
    
    assertNotNull(cliente);
    assertEquals("Juan Pérez", cliente.getNombre());
    
    clienteService.delete(cliente);
	}
	
	@Test
	public void testDelete() {
	  // Crear cliente.
    clienteService.create(cliente);
    
    // Recuperar cliente.
    cliente = clienteService.findById(cliente.getId());
    
    assertNotNull(cliente);
    
    clienteService.delete(cliente);
    
    assertNull(clienteService.findById(cliente.getId()));
	}
}
