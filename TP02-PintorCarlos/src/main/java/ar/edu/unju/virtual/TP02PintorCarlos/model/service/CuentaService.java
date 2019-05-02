package ar.edu.unju.virtual.TP02PintorCarlos.model.service;

import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cliente;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cuenta;

public interface CuentaService {
	public Cuenta create(Cuenta cuenta);	
	public Cuenta findById(Long id);
	public void update(Cuenta cuenta);
	public void deleteById(Long id);
	public Cliente getTitular(Cuenta cuenta);
}
