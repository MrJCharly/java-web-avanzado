package ar.edu.unju.virtual.TP02PintorCarlos.model.service.front;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unju.virtual.TP02PintorCarlos.model.dto.CuentaDTO;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cuenta;
import ar.edu.unju.virtual.TP02PintorCarlos.model.service.CuentaService;

@Component("cuentaFrontService")
public class CuentaFrontServiceImpl implements CuentaFrontService {

  private ModelMapper mapper = new ModelMapper();
  
  @Autowired
  CuentaService cuentaService;
  
  @Override
  public List<CuentaDTO> findAll() {
    Type listType = new TypeToken<List<CuentaDTO>>() {}.getType();
    List<Cuenta> cuentas = cuentaService.findAll(); 
    
    return mapper.map(cuentas, listType);    
  }

}
