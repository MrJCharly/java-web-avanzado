package ar.edu.unju.virtual.TP02PintorCarlos.view.bean;

import java.sql.Timestamp;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import ar.edu.unju.virtual.TP02PintorCarlos.model.dto.ClienteDTO;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cliente;

@Named("cuentaBean")
@Scope("view")
public class CuentaBean {
	private Long id;
  private String numero;
  private Timestamp fechaIngreso;
  private Double saldoActual;
  private Long limiteExtraccion;
  private String estado;  
  private String titular;
  private Long id_cliente;

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

	public Timestamp getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Double getsaldoActual() {
		return saldoActual;
	}

	public void setsaldoActual(Double saldoActual) {
		this.saldoActual = saldoActual;
	}

	public Long getLimiteExtraccion() {
		return limiteExtraccion;
	}

	public void setLimiteExtraccion(Long limiteExtraccion) {
		this.limiteExtraccion = limiteExtraccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

  public Long getId_cliente() {
    return id_cliente;
  }

  public void setId_cliente(Long idCliente) {
    this.id_cliente = idCliente;
  }      
	
}
