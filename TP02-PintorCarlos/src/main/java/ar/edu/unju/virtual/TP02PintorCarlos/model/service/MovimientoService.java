package ar.edu.unju.virtual.TP02PintorCarlos.model.service;

import java.sql.Timestamp;

import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Movimiento;

public interface MovimientoService {
  public Movimiento create(Movimiento mov);
  public Movimiento update(Movimiento mov);
  public Movimiento findById(Long id);
  public void delete(Movimiento mov);
  public Iterable<Movimiento> findByFecha(Timestamp fecha);
}
