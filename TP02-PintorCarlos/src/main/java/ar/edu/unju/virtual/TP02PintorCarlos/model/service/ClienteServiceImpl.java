package ar.edu.unju.virtual.TP02PintorCarlos.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unju.virtual.TP02PintorCarlos.model.dao.ClienteRepository;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cliente;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cuenta;

@Component("clienteService")
public class ClienteServiceImpl implements ClienteService {
	
  @Autowired  
  private ClienteRepository clienteRepo;

  @Override
  public Cliente create(Cliente cliente) {  
  	return clienteRepo.save(cliente);
  }
  
  @Override
  public Cliente update(Cliente cliente) {
    return clienteRepo.save(cliente);
  }
  
  @Override
  public Cliente findById(Long id) {
  	return clienteRepo.findById(id).orElse(null);
  }
  
  @Override
  public void deleteById(Long id) {
    clienteRepo.deleteById(id);
  }
  
  @Override
  public void addCuenta(Cuenta cuenta) {
    
  }

  @Override
  public Iterable<Cuenta> getCuentas(Cliente cliente) {
    return cliente.getCuentas();
  }

  @Override
  public Cliente findByUsuarioAndPassword(String usuario, String password) {
    return clienteRepo.findByNombreUsuarioAndClave(usuario, password);
  }

	@Override
	public List<Cliente> getClientes() {				
		return (List<Cliente>) clienteRepo.findAllByOrderByNombreAsc();
	}

}
