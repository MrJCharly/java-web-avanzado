package ar.edu.unju.virtual.TP02PintorCarlos.model.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name="cuentas_bancarias")
public class Cuenta {
  
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cuentas_bancarias_id_seq")
  @SequenceGenerator(sequenceName="cuentas_bancarias_id_seq", allocationSize=1, name="cuentas_bancarias_id_seq")
  private Long id;
  
  private String numero;
  
  @Column(name="fecha_ingreso")
  private Timestamp fechaIngreso;
  
  @Column(name="saldo_actual")
  private Double saldoActual;
  
  private String estado;
  
  @Column(name="limite_extraccion")
  private Long limiteExtraccion;
  
  @ManyToOne
  @JoinColumn(name="id_cliente", nullable = false)
  private Cliente titular;

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

  public Double getSaldoActual() {
    return saldoActual;
  }

  public void setSaldoActual(Double saldoActual) {
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

  public Cliente getTitular() {
    return titular;
  }

  public void setTitular(Cliente titular) {
    this.titular = titular;
  }
  
}
