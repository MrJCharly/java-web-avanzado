package ar.edu.unju.virtual.TP02PintorCarlos.model.service;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unju.virtual.TP02PintorCarlos.Tp02PintorCarlosApplication;
import ar.edu.unju.virtual.TP02PintorCarlos.model.dto.ClienteDTO;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cliente;

@Component("frontService")
public class FrontServiceImpl implements FrontService {
	private static final Logger LOG = LoggerFactory.getLogger(Tp02PintorCarlosApplication.class); 
	
	private ModelMapper mapper = new ModelMapper();
	
  @Autowired
  private ClienteService clienteService;
    
  @Override
  public ClienteDTO findCliente(String usuario, String password) {    
    Cliente cliente = clienteService.findByUsuarioAndPassword(usuario, password);
    
    return cliente != null ? mapper.map(cliente, ClienteDTO.class) : null;
  }

	@Override
	public List<ClienteDTO> findClientes() {	  
	  Type listType = new TypeToken<List<ClienteDTO>>() {}.getType();	  
		return mapper.map(clienteService.getClientes(), listType);
	}

  @Override
  public ClienteDTO findClienteById(Long id) {        
    return mapper.map(clienteService.findById(id), ClienteDTO.class);
  }

  @Override
  public void saveCliente(ClienteDTO dto) {
    Cliente cliente = new Cliente();
    mapper.map(dto, cliente);
    clienteService.update(cliente);
  }

}
