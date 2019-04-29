package ar.edu.unju.virtual.TP02PintorCarlos.model.service;

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
	public Cliente getTitular(Cuenta cuenta) {
		return cuenta.getTitular();
	}

}
