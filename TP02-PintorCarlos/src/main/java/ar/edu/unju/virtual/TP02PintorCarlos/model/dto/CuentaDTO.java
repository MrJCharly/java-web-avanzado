package ar.edu.unju.virtual.TP02PintorCarlos.model.dto;

import java.io.Serializable;

public class CuentaDTO implements Serializable {
  private static final long serialVersionUID = 1L;
  private String numero;
  private String saldo;
  private String estado;
  
  public CuentaDTO() { }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getSaldo() {
    return saldo;
  }

  public void setSaldo(String saldo) {
    this.saldo = saldo;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }
  
}
