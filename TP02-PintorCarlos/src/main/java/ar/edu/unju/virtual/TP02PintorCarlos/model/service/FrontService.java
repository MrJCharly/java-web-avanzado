package ar.edu.unju.virtual.TP02PintorCarlos.model.service;

import java.util.List;

import ar.edu.unju.virtual.TP02PintorCarlos.model.dto.ClienteDTO;
import ar.edu.unju.virtual.TP02PintorCarlos.view.bean.ClienteBean;

public interface FrontService {
  public ClienteDTO findCliente(String usuario, String password);
  public List<ClienteDTO> findClientes();
  public ClienteDTO findClienteById(Long id);  
  public void saveCliente(ClienteDTO cliente);
}
