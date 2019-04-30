package ar.edu.unju.virtual.TP02PintorCarlos.model.dao;

import java.sql.Timestamp;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Movimiento;

public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {

  public Iterable<Movimiento> findByFecha(Timestamp fecha);

}
