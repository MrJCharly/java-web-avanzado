package ar.edu.unju.virtual.TP02PintorCarlos.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="roles")
public class Rol {
  
  @Id
  @GeneratedValue
  @Column(name="rol_id")
  private Long id;
  
  private String descripcion;
  
  public Rol() {}

  public Rol(String descripcion) {
    super();
    this.descripcion = descripcion;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  
}
