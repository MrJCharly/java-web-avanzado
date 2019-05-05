package ar.edu.unju.virtual.TP02PintorCarlos.model.service;

import ar.edu.unju.virtual.TP02PintorCarlos.model.dto.ClienteDTO;

public interface FrontService {
  public ClienteDTO findCliente(String usuario, String password);
}
