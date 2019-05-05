package ar.edu.unju.virtual.TP02PintorCarlos.model.dto;

import java.io.Serializable;

public class ClienteDTO implements Serializable {
  private static final long serialVersionUID = 1L;
  private String nombre;
  private String nombreUsuario;  
  private String email;
  private String estado;
  private String rolDescripcion;
  
  public ClienteDTO() { }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getNombreUsuario() {
    return nombreUsuario;
  }

  public void setNombreUsuario(String nombreUsuario) {
    this.nombreUsuario = nombreUsuario;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getRolDescripcion() {
    return rolDescripcion;
  }

  public void setRolDescripcion(String rolDescripcion) {
    this.rolDescripcion = rolDescripcion;
  }
  
}
