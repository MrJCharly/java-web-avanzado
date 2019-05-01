package ar.edu.unju.virtual.TP02PintorCarlos.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unju.virtual.TP02PintorCarlos.model.dao.RolRepository;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Rol;

@Component("rolService")
public class RolServiceImpl implements RolService {
  @Autowired
  private RolRepository repo;
  
  @Override
  public Rol create(Rol rol) {
    return repo.save(rol);
  }

  @Override
  public Rol update(Rol rol) {
    return repo.save(rol);
  }
  
  @Override
  public Rol findById(Long id) {
    return repo.findById(id).orElse(null);
  }
  
  @Override
  public void delete(Rol rol) {
    repo.delete(rol);
  }

}
