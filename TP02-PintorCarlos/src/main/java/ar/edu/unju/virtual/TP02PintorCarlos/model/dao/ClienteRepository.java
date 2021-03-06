package ar.edu.unju.virtual.TP02PintorCarlos.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cliente;

@Component("clienteRepo")
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
  public Optional<Cliente> findByNombre(String nombre);
  public Cliente findByNombreUsuarioAndClave(String usuario, String password);
  public List<Cliente> findAllByOrderByNombreAsc();
}
