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
import ar.edu.unju.virtual.TP02PintorCarlos.model.dto.ClienteDTO;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cliente;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Rol;
import ar.edu.unju.virtual.TP02PintorCarlos.model.service.ClienteService;
import ar.edu.unju.virtual.TP02PintorCarlos.model.service.FrontService;
import ar.edu.unju.virtual.TP02PintorCarlos.model.service.RolService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Tp02PintorCarlosApplication.class)
public class FrontServiceTest {
  private Rol rol;
  private Cliente cliente;

  @Autowired
  private RolService rolService;
  
  @Autowired
  private ClienteService clienteService;
  
  @Autowired
  private FrontService frontService;
  
  @Before
  public void before_tests() {
    rol = new Rol("USER");
    cliente = Util.getCliente(rol);
    
    // Crear rol.
    rolService.create(rol);
    
    // Crear cliente.
    clienteService.create(cliente);    
  }
  
  public void restaurar_BD() {
    clienteService.deleteById(cliente.getId());
    rolService.deleteById(rol.getId());
  }
  
  @Test
  public void testFindCliente() {
    ClienteDTO clienteDto;
    
    //
    // Recuperar clienteDTO con credenciales incorrectas.
    //
    
    // nombreUsuario y clave incorrectos.
    clienteDto = frontService.findCliente("null", "null");
    
    assertNull(clienteDto);
    
    // nombreUsuario correcto y clave incorrecta.
    clienteDto = frontService.findCliente(cliente.getNombreUsuario(), "null");
    
    assertNull(clienteDto);
    
    // nombreUsuario incorrecto y clave correcta.
    clienteDto = frontService.findCliente("null", cliente.getClave());
    
    assertNull(clienteDto);
    
    //
    // Recuperar clienteDTO con credenciales correctas.
    //
    
    clienteDto = frontService.findCliente(cliente.getNombreUsuario(), cliente.getClave());
    
    assertNotNull(clienteDto);
    
    // Verificar contenido del DTO.
    assertEquals(clienteDto.getEmail(), cliente.getEmail());
    assertEquals(clienteDto.getEstado(), cliente.getEstado());
    assertEquals(clienteDto.getNombre(), cliente.getNombre());
    assertEquals(clienteDto.getNombreUsuario(), cliente.getNombreUsuario());
    assertEquals(clienteDto.getRolDescripcion(), "USER");
    assertEquals(clienteDto.getRolDescripcion(), cliente.getRol().getDescripcion());
    
    restaurar_BD();
  }
}
