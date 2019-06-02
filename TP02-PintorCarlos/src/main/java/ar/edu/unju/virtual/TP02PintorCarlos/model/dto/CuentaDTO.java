package ar.edu.unju.virtual.TP02PintorCarlos.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cliente;

public class CuentaDTO implements Serializable {
  private static final long serialVersionUID = 1L;
  private Long id;
  private String numero;
  private Timestamp fechaIngreso;
  private Long limiteExtraccion;
  private Double saldoActual;
  private String estado;  
  private Cliente titular;
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

  public Double getsaldoActual() {
    return saldoActual;
  }

  public void setsaldoActual(Double saldoActual) {
    this.saldoActual = saldoActual;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public Long getLimiteExtraccion() {
		return limiteExtraccion;
	}

	public void setLimiteExtraccion(Long limiteExtraccion) {
		this.limiteExtraccion = limiteExtraccion;
	}

	public Timestamp getFechaIngreso() {
    return fechaIngreso;
  }

  public void setFechaIngreso(Timestamp fechaIngreso) {
    this.fechaIngreso = fechaIngreso;
  }  

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
  
  public String getFormattedNumero() {
  	return String.format("%15s", numero).replace(' ', '0');
  }
  
  public Long getId_cliente() {
    return id_cliente;
  }

  public void setId_cliente(Long id_cliente) {
    this.id_cliente = id_cliente;
  }

  public String toString() {
    return getFormattedNumero();
  }
}
