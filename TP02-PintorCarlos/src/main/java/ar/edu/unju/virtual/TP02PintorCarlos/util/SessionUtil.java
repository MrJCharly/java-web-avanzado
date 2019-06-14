package ar.edu.unju.virtual.TP02PintorCarlos.util;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("sessionUtil")
@Scope("session")
public class SessionUtil {	
	Map<String, Object> sessionMap;
	
	@PostConstruct
	public void postConstruct() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		sessionMap = externalContext.getSessionMap();
	}
	
	public void put(String key, Object obj) {				
		sessionMap.put(key, obj);
	}
	
	public Object get(String key) {
		return sessionMap.get(key);
	}
}
