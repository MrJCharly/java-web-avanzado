package ar.edu.unju.virtual.TP02PintorCarlos.view.controller.cuenta;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.component.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import ar.edu.unju.virtual.TP02PintorCarlos.Tp02PintorCarlosApplication;
import ar.edu.unju.virtual.TP02PintorCarlos.model.dto.CuentaDTO;
import ar.edu.unju.virtual.TP02PintorCarlos.model.service.front.CuentaFrontService;
import ar.edu.unju.virtual.TP02PintorCarlos.view.bean.CuentaBean;

@Named("cuentaCtrl")
@Scope("request")
public class CuentaController {
	private static final Logger LOG = LoggerFactory.getLogger(Tp02PintorCarlosApplication.class);
	
	private List<CuentaDTO> cuentas;
  private List<CuentaDTO> filteredCuentas;
  private CuentaDTO currCuenta;
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

  @PostConstruct
  public void postConstruct() {
    cuentas = cuentaFrontService.findAll();
    LOG.info("POSTCONSTRUCT");
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
    return cuentas;
  }

  public void setCuentas(List<CuentaDTO> cuentas) {
		this.cuentas = cuentas;
	}

	public List<CuentaDTO> getFilteredCuentas() {
    return filteredCuentas;
  }

  public void setFilteredCuentas(List<CuentaDTO> filteredCuentas) {
    this.filteredCuentas = filteredCuentas;
  }
  
  public CuentaDTO getCurrCuenta() {
		return currCuenta;
	}

	public void setCurrCuenta(CuentaDTO currCuenta) {
		this.currCuenta = currCuenta;
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
  
  public void delete(CuentaDTO cuenta) {
  	cuentas.remove(cuenta);
  	cuentaFrontService.delete(cuenta.getId());  	
  }
}
