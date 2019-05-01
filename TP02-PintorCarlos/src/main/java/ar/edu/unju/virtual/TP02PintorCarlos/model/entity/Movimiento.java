package ar.edu.unju.virtual.TP02PintorCarlos.model.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name="movimientos")
public class Movimiento {
  
  public Movimiento() { }
  
  public Movimiento(Cuenta cuenta, Timestamp fecha, Double debito, Double credito, Double saldo, Cliente titular) {
    super();
    this.cuenta = cuenta;
    this.fecha = fecha;
    this.debito = debito;
    this.credito = credito;
    this.saldo = saldo;
    this.titular = titular;
  }

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="movimientos_id_seq")
  @SequenceGenerator(sequenceName="movimientos_id_seq", allocationSize=1, name="movimientos_id_seq")
  private Long id;
  
  @ManyToOne
  @JoinColumn(name="id_cuenta_bancaria", nullable=false)
  private Cuenta cuenta;
  
  private Timestamp fecha;  
  private Double debito;
  private Double credito;
  private Double saldo;
  
  @ManyToOne
  @JoinColumn(name="id_cliente", nullable=false)
  private Cliente titular;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Cuenta getCuenta() {
    return cuenta;
  }

  public void setCuenta(Cuenta cuenta) {
    this.cuenta = cuenta;
  }

  public Timestamp getFecha() {
    return fecha;
  }

  public void setFecha(Timestamp fecha) {
    this.fecha = fecha;
  }

  public Double getDebito() {
    return debito;
  }

  public void setDebito(Double debito) {
    this.debito = debito;
  }

  public Double getCredito() {
    return credito;
  }

  public void setCredito(Double credito) {
    this.credito = credito;
  }

  public Double getSaldo() {
    return saldo;
  }

  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }

  public Cliente getTitular() {
    return titular;
  }

  public void setTitular(Cliente titular) {
    this.titular = titular;
  }

  @Override
  public String toString() {
    return "Movimiento [id=" + id + ", cuenta=" + cuenta + ", fecha=" + fecha + ", debito=" + debito + ", credito="
        + credito + ", saldo=" + saldo + ", titular=" + titular + "]";
  }
  
  
}
