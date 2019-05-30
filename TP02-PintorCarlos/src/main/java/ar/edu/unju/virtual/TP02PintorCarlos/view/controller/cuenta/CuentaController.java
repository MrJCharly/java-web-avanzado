package ar.edu.unju.virtual.TP02PintorCarlos.view.controller.cuenta;

import java.util.Arrays;
import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.virtual.TP02PintorCarlos.model.dto.CuentaDTO;
import ar.edu.unju.virtual.TP02PintorCarlos.model.service.front.CuentaFrontService;

@Named("cuentaCtrl")
public class CuentaController {  
  private List<CuentaDTO> filteredCuentas;
  private final static String[] estados;
  
  @Autowired
  private CuentaFrontService cuentaFrontService;
  
  static {
    estados = new String[2];
    estados[0] = "HABILITADO";
    estados[1] = "INHABILITADO";    
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
  
  
}
