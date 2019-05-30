package ar.edu.unju.virtual.TP02PintorCarlos.model.service.front;

import java.util.List;

import ar.edu.unju.virtual.TP02PintorCarlos.model.dto.CuentaDTO;

public interface CuentaFrontService {
  public List<CuentaDTO> findAll();
}
