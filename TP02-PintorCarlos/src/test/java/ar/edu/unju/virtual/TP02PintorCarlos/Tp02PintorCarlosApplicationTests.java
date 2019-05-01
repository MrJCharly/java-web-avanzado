package ar.edu.unju.virtual.TP02PintorCarlos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.edu.unju.virtual.TP02PintorCarlos.model.dao.ClienteRepository;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tp02PintorCarlosApplicationTests {
  private static final Logger LOG = LoggerFactory.getLogger(Tp02PintorCarlosApplicationTests.class);
  
  @Autowired
  @Qualifier("clienteRepo")
  private ClienteRepository clienteRepo;
  private Cliente cliente;
  
	@Test
	public void testCreate() {
	  LOG.info("TestCreate - Start");
	  createCliente();
	  
	  // Intentar recuperar cliente creado.
	  Cliente clienteCreado = clienteRepo.findById(cliente.getId()).orElse(null);
	  
	  assertNotNull(clienteCreado);
	  assertEquals(cliente.getId(), clienteCreado.getId());
	  
	  deleteCliente(cliente.getId());
	  LOG.info("TestCreate - End");
	}
	
	@Test
	public void testUpdate() {
	  LOG.info("TestUpdate - Start");
	  createCliente();
	  
	  Cliente clienteModificado;	  
	  cliente.setNombre("Juan Perez");	  
	  clienteRepo.save(cliente);
	  
	  // Intentar recuperar cliente modificado.
    clienteModificado = clienteRepo.findById(cliente.getId()).orElse(null);
    
    assertNotNull(clienteModificado);
    assertEquals(cliente.getNombre(), clienteModificado.getNombre());
    
    deleteCliente(cliente.getId());
    LOG.info("TestUpdate - End");
	}

	@Test
	public void testDelete() {
	  LOG.info("TestDelete - Start");
	  createCliente();
	  
	  Cliente clienteEliminado;
	  clienteRepo.delete(cliente);
	  
	  // Intentar recuperar cliente modificado.
    clienteEliminado = clienteRepo.findById(cliente.getId()).orElse(null);
    
    assertNull(clienteEliminado);
    LOG.info("TestDelete - End");
	}
	
	private Cliente createCliente() {
    cliente = new Cliente(
      12345678L,
      "john.doe",
      "j0hn.d03",
      "John Doe",
      "120 Redberry Road",
      "john.doe@hotmail.com",
      "HABILITADO",
      null
    );
    
    LOG.info("Creando cliente... " + cliente);
    return clienteRepo.save(cliente);
  }
	
	private void deleteCliente(long id) {
	  LOG.info("Borrando cliente... " + id);
	  clienteRepo.deleteById(id);
	}
}
