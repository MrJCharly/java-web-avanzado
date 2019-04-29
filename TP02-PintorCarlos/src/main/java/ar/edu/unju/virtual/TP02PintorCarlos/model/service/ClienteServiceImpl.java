package ar.edu.unju.virtual.TP02PintorCarlos.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unju.virtual.TP02PintorCarlos.model.dao.ClienteRepository;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cliente;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cuenta;

@Component("service")
public class ClienteServiceImpl implements ClienteService {
	
  @Autowired  
  private ClienteRepository clienteRepo;

  @Override
  public Cliente create(Cliente cliente) {  
  	return clienteRepo.save(cliente);
  }
  
  @Override
  public void delete(Cliente cliente) {
  	clienteRepo.delete(cliente);
  }
  
  @Override
  public Cliente findById(Long id) {
  	return clienteRepo.findById(id).orElse(null);
  }
  
  @Override
  public void addCuenta(Cuenta cuenta) {
    
  }

  @Override
  public Iterable<Cuenta> getCuentas(Cliente cliente) {
    return cliente.getCuentas();
  }



}
