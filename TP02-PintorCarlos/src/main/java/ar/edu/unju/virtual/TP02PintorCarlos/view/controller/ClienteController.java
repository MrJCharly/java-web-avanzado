package ar.edu.unju.virtual.TP02PintorCarlos.view.controller;

import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unju.virtual.TP02PintorCarlos.Tp02PintorCarlosApplication;
import ar.edu.unju.virtual.TP02PintorCarlos.model.dto.ClienteDTO;
import ar.edu.unju.virtual.TP02PintorCarlos.model.service.FrontService;

@Component("clienteCtrl")
@ViewScoped
public class ClienteController {
	private static final Logger LOG = LoggerFactory.getLogger(Tp02PintorCarlosApplication.class);
	
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
		LOG.info("GET_CLIENTES");
		return frontService.findClientes();
	}
	
	public List<String> getEstados() {
		LOG.info("GET_ESTADOS");
	  return Arrays.asList(estados);
	}
}
