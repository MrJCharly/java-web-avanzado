package ar.edu.unju.virtual.TP02PintorCarlos.view.controller;

import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unju.virtual.TP02PintorCarlos.Tp02PintorCarlosApplication;
import ar.edu.unju.virtual.TP02PintorCarlos.model.dto.ClienteDTO;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cliente;
import ar.edu.unju.virtual.TP02PintorCarlos.model.service.ClienteService;
import ar.edu.unju.virtual.TP02PintorCarlos.model.service.FrontService;
import ar.edu.unju.virtual.TP02PintorCarlos.view.bean.ClienteBean;

@Component("clienteCtrl")
@ViewScoped
public class ClienteController {
	private static final Logger LOG = LoggerFactory.getLogger(Tp02PintorCarlosApplication.class);
	
	@Autowired
	private ClienteService clienteService;
	
	@Inject
	private ClienteBean bean;
	
	private List<ClienteDTO> clientes;
	private List<ClienteDTO> filteredClientes;
	
	@Autowired
	private FrontService frontService;
	
	private final static String[] estados;
	
	static {
    estados = new String[2];
    estados[0] = "HABILITADO";
    estados[1] = "INHABILITADO";    
	}
	
	public void init() {
	  LOG.info("BEAN ID:" + bean.getId());
	  
	  if (bean.getId() != null) {
	    populateClienteBeanFromId(bean);
	  }
	}
	
	private void populateClienteBeanFromId(ClienteBean bean) {
    ClienteDTO cliente = frontService.findClienteById(bean.getId());    
    BeanUtils.copyProperties(cliente, bean);
  }

  public List<ClienteDTO> getFilteredClientes() {
		return filteredClientes;
	}

	public void setFilteredClientes(List<ClienteDTO> filteredClientes) {
		this.filteredClientes = filteredClientes;
	}

	public void setClientes(List<ClienteDTO> clientes) {
		this.clientes = clientes;
	}

	public List<ClienteDTO> getClientes() {		
		return frontService.findClientes();
	}
	
	public List<String> getEstados() {		
	  return Arrays.asList(estados);
	}
	
	public String save() {
	  ClienteDTO cliente = new ClienteDTO();
    BeanUtils.copyProperties(bean, cliente);    
    frontService.saveCliente(cliente);    
	  
	  return "clientes.xhtml?faces-redirect=true";
	}		
}
