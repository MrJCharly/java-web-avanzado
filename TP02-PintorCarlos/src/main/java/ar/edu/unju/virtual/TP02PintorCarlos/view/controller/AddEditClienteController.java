package ar.edu.unju.virtual.TP02PintorCarlos.view.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cliente;
import ar.edu.unju.virtual.TP02PintorCarlos.model.service.ClienteService;

@Named("addEditClienteCtrl")
@ViewScoped
public class AddEditClienteController implements Serializable {
	
	@Autowired
	private ClienteService clienteService;
	
	public void onRowEdit(RowEditEvent event) {
    FacesMessage msg = new FacesMessage("Cliente modificado");
    FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	 
	public void onRowCancel(RowEditEvent event) {
    FacesMessage msg = new FacesMessage("Acción cancelada");
    FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onAddNew() {
    // Add one new car to the table:
    Cliente cliente = clienteService.create(new Cliente());
    //cars1.add(car2Add);
    
    FacesMessage msg = new FacesMessage("Nuevo cliente agregado");
    FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
