package ar.edu.unju.virtual.TP02PintorCarlos.model.service;

import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cuenta;

public interface ClienteService {
  public void addCuenta(Cuenta cuenta);
  public Iterable<Cuenta> getCuentas();
}
