package ar.edu.unju.virtual.TP02PintorCarlos.view.bean.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.virtual.TP02PintorCarlos.model.dto.ClienteDTO;

@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter<ClienteDTO> {

	@Autowired
	
	
	@Override
	public ClienteDTO getAsObject(FacesContext context, UIComponent component, String value) {
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, ClienteDTO value) {
		// TODO Auto-generated method stub
		return null;
	}

}
