package ar.edu.unju.virtual.TP02PintorCarlos.model.service;

import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cliente;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cuenta;

public interface ClienteService {
	public Cliente create(Cliente cliente);
	public Cliente update(Cliente cliente);
	public void delete(Cliente cliente);
	public Cliente findById(Long id);
  public void addCuenta(Cuenta cuenta);
  public Iterable<Cuenta> getCuentas(Cliente cliente);
}
