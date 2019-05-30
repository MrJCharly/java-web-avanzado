package ar.edu.unju.virtual.TP02PintorCarlos.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class CuentaDTO implements Serializable {
  private static final long serialVersionUID = 1L;
  private Long id;
  private String numero;
  private Timestamp fechaIngreso;
  private String saldo;
  private String estado;
  private Long id_cliente;
  
  public CuentaDTO() { }
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public Timestamp getFechaIngreso() {
    return fechaIngreso;
  }

  public void setFechaIngreso(Timestamp fechaIngreso) {
    this.fechaIngreso = fechaIngreso;
  }

  public Long getId_cliente() {
    return id_cliente;
  }

  public void setId_cliente(Long id_cliente) {
    this.id_cliente = id_cliente;
  }
  
  
}
