package ar.edu.unju.virtual.TP02PintorCarlos.model.service.front;

import java.util.List;

import ar.edu.unju.virtual.TP02PintorCarlos.model.dto.CuentaDTO;
import ar.edu.unju.virtual.TP02PintorCarlos.view.bean.CuentaBean;

public interface CuentaFrontService {
  public List<CuentaDTO> findAll();
	public CuentaDTO findCuentaById(Long id);
	public void save(CuentaBean bean);
}
