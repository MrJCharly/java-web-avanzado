package ar.edu.unju.virtual.TP03PintorCarlos;

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
public class CuentaTest {
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
    
    // Recuperar cuenta.
    cuenta = cuentaService.findById(cuenta.getId());
    
    // Verificar que existe en BD.
    assertNotNull(cuenta);
    
    restaurar_BD();
  }
  
	@Test
	public void testUpdate() {

	  // Modificar número de cuenta.
    cuenta.setNumero("123456789");
    
    cuentaService.update(cuenta);
    
    // Recuperar cuenta.
    cuenta = cuentaService.findById(cuenta.getId());
    
    // Verificar cambios en BD.
    assertNotNull(cuenta);
    assertEquals("123456789", cuenta.getNumero());
    
    restaurar_BD();
	}
	
	@Test
	public void testDelete() {
	      
    // Recuperar cuenta.
	  cuenta = cuentaService.findById(cuenta.getId());
    
    // Verificar que existe en BD.
    assertNotNull(cuenta);
    
    restaurar_BD();
    
    // Verificar que fue eliminada de BD.
    assertNull(cuentaService.findById(cuenta.getId()));
	}
}
