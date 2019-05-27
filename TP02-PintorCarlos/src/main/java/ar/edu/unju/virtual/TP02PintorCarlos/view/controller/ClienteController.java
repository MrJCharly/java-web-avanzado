package ar.edu.unju.virtual.TP02PintorCarlos.view.controller;

import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unju.virtual.TP02PintorCarlos.model.dto.ClienteDTO;
import ar.edu.unju.virtual.TP02PintorCarlos.model.service.FrontService;

@Component("clienteCtrl")
@ViewScoped
public class ClienteController {
	@Autowired
	private FrontService frontService;
	
	private final static String[] estados;
	
	static {
    estados = new String[2];
    estados[0] = "HABILITADO";
    estados[1] = "INHABILITADO";    
	}
	
	public List<ClienteDTO> getClientes() {
		return frontService.findClientes();
	}
	
	public List<String> getEstados() {
	  return Arrays.asList(estados);
	}
}
