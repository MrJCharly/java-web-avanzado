package ar.edu.unju.virtual.TP02PintorCarlos.view.controller.cuenta;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import ar.edu.unju.virtual.TP02PintorCarlos.model.dto.CuentaDTO;
import ar.edu.unju.virtual.TP02PintorCarlos.model.service.front.CuentaFrontService;
import ar.edu.unju.virtual.TP02PintorCarlos.view.bean.CuentaBean;

@Named("cuentaCtrl")
@Scope("request")
public class CuentaController {  
  private List<CuentaDTO> filteredCuentas;
  private final static String[] estados;
  
  @Autowired
  private CuentaFrontService cuentaFrontService;
  
  @Inject
  private CuentaBean bean;
  
  static {
    estados = new String[2];
    estados[0] = "HABILITADO";
    estados[1] = "INHABILITADO";    
  }

  public void init() {
  	if (bean.getId() != null) {
	    populateClienteBeanFromId(bean);
	  }
  }
  
  private void populateClienteBeanFromId(CuentaBean bean) {		
  	CuentaDTO cuenta = cuentaFrontService.findCuentaById(bean.getId());    
    BeanUtils.copyProperties(cuenta, bean);
	}

	public List<String> getEstados() {    
    return Arrays.asList(estados);
  }

  public List<CuentaDTO> getCuentas() {
    return cuentaFrontService.findAll();
  }

  public List<CuentaDTO> getFilteredCuentas() {
    return filteredCuentas;
  }

  public void setFilteredCuentas(List<CuentaDTO> filteredCuentas) {
    this.filteredCuentas = filteredCuentas;
  }
  
  public String create() {  	
  	return "createUpdate.xhtml?faces-redirect=true";
  }
  
  public String save() {
  	if (bean.getId() == null) {
  		// Fecha ingreso.
  		bean.setFechaIngreso(new Timestamp(System.currentTimeMillis()));
  		
  		// Saldo.
  		bean.setsaldoActual(0d);
  	}
  	
  	cuentaFrontService.save(bean);
  	return "admin.xhtml?faces-redirect=true";
  }
}
