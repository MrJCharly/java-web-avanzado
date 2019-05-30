package ar.edu.unju.virtual.TP02PintorCarlos.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unju.virtual.TP02PintorCarlos.model.dao.CuentaRepository;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cliente;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cuenta;

@Component("cuentaService")
public class CuentaServiceImpl implements CuentaService {
	
	@Autowired
	private CuentaRepository cuentaRepo;

	@Override
	public Cuenta create(Cuenta cuenta) {
		return cuentaRepo.save(cuenta);
	}

	@Override
	public Cuenta findById(Long id) {
	  return cuentaRepo.findById(id).orElse(null);
	}
	
	@Override
	public void update(Cuenta cuenta) {
	  cuentaRepo.save(cuenta);
	}
	
	@Override
	public void deleteById(Long id) {
	  cuentaRepo.deleteById(id);
	}
	
	@Override
	public Cliente getTitular(Cuenta cuenta) {
		return cuenta.getTitular();
	}

  @Override
  public List<Cuenta> findAll() {   
    return (List<Cuenta>) cuentaRepo.findAll();
  }
}
