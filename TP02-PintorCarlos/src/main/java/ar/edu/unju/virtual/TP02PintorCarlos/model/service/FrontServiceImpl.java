package ar.edu.unju.virtual.TP02PintorCarlos.model.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unju.virtual.TP02PintorCarlos.model.dto.ClienteDTO;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cliente;

@Component("frontService")
public class FrontServiceImpl implements FrontService {
  @Autowired
  private ClienteService clienteService;
    
  @Override
  public ClienteDTO findCliente(String usuario, String password) {
    ModelMapper mapper = new ModelMapper();
    Cliente cliente = clienteService.findByUsuarioAndPassword(usuario, password);
    
    return cliente != null ? mapper.map(cliente, ClienteDTO.class) : null;
  }

	@Override
	public List<ClienteDTO> findClientes() {
	  ModelMapper mapper = new ModelMapper();return null;
		//return mapper.map(clienteService.getClientes(), ClienteDTO.class);
	}

}
