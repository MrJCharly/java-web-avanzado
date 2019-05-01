package ar.edu.unju.virtual.TP02PintorCarlos.model.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unju.virtual.TP02PintorCarlos.model.dao.MovimientoRepository;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Movimiento;

@Component("movService")
public class MovimientoServiceImpl implements MovimientoService {
  
  @Autowired
  private MovimientoRepository repo;
  
  @Override
  public Movimiento create(Movimiento mov) {
    return repo.save(mov);
  }
  
  @Override
  public Movimiento update(Movimiento mov) {
    return repo.save(mov);
  }

  @Override
  public Movimiento findById(Long id) {
    return repo.findById(id).orElse(null);
  }
  
  @Override
  public void deleteById(Long id) {
    repo.deleteById(id);
  }

  @Override
  public Iterable<Movimiento> findByFecha(Timestamp fecha) {
    return repo.findByFecha(fecha);
  }
  
}
