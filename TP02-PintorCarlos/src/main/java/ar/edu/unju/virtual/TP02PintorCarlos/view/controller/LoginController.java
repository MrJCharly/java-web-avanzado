package ar.edu.unju.virtual.TP02PintorCarlos.view.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ar.edu.unju.virtual.TP02PintorCarlos.model.bean.LoginBean;
import ar.edu.unju.virtual.TP02PintorCarlos.model.dto.ClienteDTO;
import ar.edu.unju.virtual.TP02PintorCarlos.model.service.FrontService;

@Component("loginController")
@Scope("request")
public class LoginController {
	
	@Autowired
	private FrontService frontService;
	
	@Inject
	private LoginBean loginBean;

	private ClienteDTO cliente;
	
	public String login() {
		cliente = findCliente();
		
		if (cliente == null) {
			addErrorMessage();			
			return "";
		}
		
		doLogin();
		
		return "home";
	}

	private ClienteDTO findCliente() {
		return frontService.findCliente(
			loginBean.getUsername(), 
			loginBean.getPassword());
	}

	private void addErrorMessage() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrectos.", null);
    FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	private void doLogin() {
		// TODO
	}
	
}
