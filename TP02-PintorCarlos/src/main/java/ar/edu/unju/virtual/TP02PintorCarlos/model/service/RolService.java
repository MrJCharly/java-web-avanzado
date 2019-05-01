package ar.edu.unju.virtual.TP02PintorCarlos.model.service;

import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Rol;

public interface RolService {
	public Rol create(Rol rol);
	public Rol update(Rol rol);  
	public Rol findById(Long id);
	public void delete(Rol rol);
}
