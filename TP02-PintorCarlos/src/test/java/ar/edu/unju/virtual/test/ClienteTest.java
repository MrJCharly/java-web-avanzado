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
  	
  	// Crear cliente.
    clienteService.create(cliente);
    
    // Abrir cuenta y asignarle titular.
    cuentaService.create(cuenta);
  }
  
  public void restaurar_BD() {
    cuentaService.deleteById(cuenta.getId());
    clienteService.deleteById(cliente.getId());
  }

  @Test
  public void testCreateAndRetrieve() {    
    
    // Recuperar cliente.
    cliente = clienteService.findById(cliente.getId());
    
    // Verificar que existe en BD.
    assertNotNull(cliente);
    
    restaurar_BD();
  }
  
	@Test
	public void testGetCuentas() {
					
		// Recuperar cliente con sus cuentas.
		cliente = clienteService.findById(cliente.getId()); 
		
		// Verificar que la cuenta fue asignada al cliente.
		assertEquals(1, cliente.getCuentas().size());
		assertEquals(cuenta.getId(), cliente.getCuentas().get(0).getId());
		
		restaurar_BD();		
	}		

	@Test
	public void testUpdate() {

	  // Modificar cliente.
    cliente.setNombre("Juan Pérez");
    
    clienteService.update(cliente);
    
    // Recuperar cliente.
    cliente = clienteService.findById(cliente.getId());
    
    // Verificar cambios en BD.
    assertNotNull(cliente);
    assertEquals("Juan Pérez", cliente.getNombre());
    
    restaurar_BD();
	}
	
	@Test
	public void testDelete() {
	      
    // Recuperar cliente.
    cliente = clienteService.findById(cliente.getId());
    
    // Verificar que existe en BD.
    assertNotNull(cliente);
    
    restaurar_BD();
    
    // Verificar que fue eliminado de BD.
    assertNull(clienteService.findById(cliente.getId()));
	}
}
