package ar.edu.unju.virtual.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
  }
  
  @Test
  public void testCreateAndRetrieve() {
    // Crear rol.
    rolService.create(rol);
    
    // Crear cliente.
    clienteService.create(cliente);
    
    // Abrir cuenta.    
    cuentaService.create(cuenta);
    
    // Crear movimiento.
    movService.create(mov);    
    
    mov = movService.findById(mov.getId());
    
    LOG.info("Movimiento: " + mov);
    
    cliente = clienteService.findById(cliente.getId());
    
    LOG.info("Cliente: " + cliente);
    
    assertNotNull(mov);
    assertEquals(cliente.getId(), mov.getTitular().getId());
    assertEquals(cuenta.getId(), mov.getCuenta().getId());
    
    // Restaurar DB.
    // Al utilizar cascade=CascadeType.ALL basta con eliminar cliente para
    // eliminar las cuentas asociadas y todos sus movimientos.
    clienteService.delete(cliente);
    rolService.delete(rol);
  }
  
  @Test
  public void testUpdate() {
    // Crear rol.
    rolService.create(rol);
    
    // Crear cliente.
    clienteService.create(cliente);
    
    // Abrir cuenta.    
    cuentaService.create(cuenta);
    
    // Crear movimiento.
    movService.create(mov);
    
    mov.setCredito(1245d);
    mov.setDebito(5421d);
    
    movService.update(mov);
    
    mov = movService.findById(mov.getId());
    cliente = clienteService.findById(cliente.getId());
    
    assertNotNull(mov);
    assertTrue(mov.getCredito() == 1245d);
    assertTrue(mov.getDebito() == 5421d);
    
    clienteService.delete(cliente);
    rolService.delete(rol);
  }
}
