package ar.edu.unju.virtual.TP02PintorCarlos.model.service;

import java.util.List;

import ar.edu.unju.virtual.TP02PintorCarlos.model.dto.ClienteDTO;

public interface FrontService {
  public ClienteDTO findCliente(String usuario, String password);
  public List<ClienteDTO> findClientes();
}
