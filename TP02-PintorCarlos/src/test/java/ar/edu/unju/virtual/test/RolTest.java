package ar.edu.unju.virtual.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.edu.unju.virtual.TP02PintorCarlos.Tp02PintorCarlosApplication;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Rol;
import ar.edu.unju.virtual.TP02PintorCarlos.model.service.RolService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Tp02PintorCarlosApplication.class)
public class RolTest {
  private Rol rol;
  
  @Autowired
  private RolService rolService;
  
  @Test
  public void testCreateAndRetrieve() {
    rol = new Rol("ADMIN");
    
    rolService.create(rol);
    
    rol = rolService.findById(rol.getId());
    
    assertNotNull(rol);
    
    rolService.delete(rol);
  }
  
  @Test
  public void testUpdate() {
    rol = new Rol("ADMIN");
    
    rolService.create(rol);
    
    rol.setDescripcion("CLIENTE");
    
    rolService.update(rol);
    
    rol = rolService.findById(rol.getId());
    
    assertEquals("CLIENTE", rol.getDescripcion());
    
    rolService.delete(rol);
  }
  
  @Test
  public void testDelete() {
    rol = new Rol("ADMIN");
    
    rolService.create(rol);
    
    rolService.delete(rol);
    
    rol = rolService.findById(rol.getId());
    
    assertNull(rol);
  }
}
