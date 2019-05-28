package ar.edu.unju.virtual.TP02PintorCarlos.model.service;

import java.util.List;

import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cliente;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cuenta;

public interface ClienteService {	
	public Cliente create(Cliente cliente);
	public Cliente update(Cliente cliente);
	public void deleteById(Long id);
	public Cliente findById(Long id);
  public void addCuenta(Cuenta cuenta);
  public Iterable<Cuenta> getCuentas(Cliente cliente);
  public Cliente findByUsuarioAndPassword(String usuario, String password);
	public List<Cliente> getClientes();
}
