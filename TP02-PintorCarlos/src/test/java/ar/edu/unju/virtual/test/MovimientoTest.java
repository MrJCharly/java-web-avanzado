package ar.edu.unju.virtual.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.edu.unju.virtual.TP02PintorCarlos.Tp02PintorCarlosApplication;
import ar.edu.unju.virtual.TP02PintorCarlos.Tp02PintorCarlosApplicationTests;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cliente;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cuenta;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Movimiento;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Rol;
import ar.edu.unju.virtual.TP02PintorCarlos.model.service.ClienteService;
import ar.edu.unju.virtual.TP02PintorCarlos.model.service.CuentaService;
import ar.edu.unju.virtual.TP02PintorCarlos.model.service.MovimientoService;
import ar.edu.unju.virtual.TP02PintorCarlos.model.service.RolService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Tp02PintorCarlosApplication.class)
public class MovimientoTest {
  private static final Logger LOG = LoggerFactory.getLogger(Tp02PintorCarlosApplicationTests.class);
  private Rol rol;
  private Cliente cliente;
  private Cuenta cuenta;
  private Movimiento mov;
  
  @Autowired
  private ClienteService clienteService;
  
  @Autowired
  private RolService rolService;
  
  @Autowired
  private CuentaService cuentaService;
  
  @Autowired
  private MovimientoService movService;
  
  @Before
  public void before_tests() {
    rol = new Rol("ADMIN");
    cliente = Util.getCliente(rol);    
    cuenta = Util.getCuenta(cliente);
    mov = Util.getMovimiento(cuenta, cliente);
    
    // Crear rol.
    rolService.create(rol);
    LOG.info("Rol creado " + rol);
    
    // Crear cliente.
    clienteService.create(cliente);
    LOG.info("Cliente creado " + cliente);
    
    // Abrir cuenta.    
    cuentaService.create(cuenta);
    LOG.info("Cuenta creada " + cuenta);
    
    // Crear movimiento.
    movService.create(mov);
    LOG.info("Movimiento creado " + mov);
  }
  
  private void restaurar_DB() {
    movService.deleteById(mov.getId());
    cuentaService.deleteById(cuenta.getId());
    clienteService.deleteById(cliente.getId());
    rolService.deleteById(rol.getId());    
  }
  
  @Test
  public void testCreateAndRetrieve() {
    
    // Recuperar movimiento creado en before_tests().
    mov = movService.findById(mov.getId());
    
    LOG.info("Movimiento recuperado: " + mov);
    
    cliente = clienteService.findById(cliente.getId());
    
    LOG.info("Cliente: " + cliente);
    
    assertNotNull(mov);
    assertEquals(cliente.getId(), mov.getTitular().getId());
    assertEquals(cuenta.getId(), mov.getCuenta().getId());
    
    restaurar_DB();
  }
  
  @Test
  public void testUpdate() {
    
    // Modificar credito y debito.
    mov.setCredito(1245d);
    mov.setDebito(5421d);
    
    movService.update(mov);
    
    // Recuperar movimiento de BD.
    mov = movService.findById(mov.getId());
    cliente = clienteService.findById(cliente.getId());
    
    // Verificar cambios.
    assertNotNull(mov);
    assertTrue(mov.getCredito() == 1245d);
    assertTrue(mov.getDebito() == 5421d);
    
    restaurar_DB();
  }
  
  @Test
  public void testDelete() {
    
    // Recuperar movimiento de BD.
    mov = movService.findById(mov.getId());
    
    assertNotNull(mov);    
    
    // Eliminar mov, y el resto de entidades creadas. 
    restaurar_DB();
    
    // Verificar que el movimiento no existe en BD.
    assertNull(movService.findById(mov.getId()));
  }
}
