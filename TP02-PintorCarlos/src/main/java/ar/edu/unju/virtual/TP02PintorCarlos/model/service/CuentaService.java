package ar.edu.unju.virtual.TP02PintorCarlos.model.service;

import java.util.List;

import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cliente;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cuenta;

public interface CuentaService {
  public List<Cuenta> findAll();
  public Cuenta findById(Long id);
	public Cuenta create(Cuenta cuenta);	
	public void update(Cuenta cuenta);
	public void deleteById(Long id);
	public Cliente getTitular(Cuenta cuenta);
}
