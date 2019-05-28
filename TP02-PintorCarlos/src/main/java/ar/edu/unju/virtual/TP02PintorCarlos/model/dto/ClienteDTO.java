package ar.edu.unju.virtual.TP02PintorCarlos.model.dto;

import java.io.Serializable;

public class ClienteDTO implements Serializable {
  private static final long serialVersionUID = 1L;
  private Long id;
  private Long dni;
  private String nombre;
  private String nombreUsuario;
  private String clave;
  private String email;
  private String domicilio;
  private String estado;
  private String rolDescripcion;
  private Long id_cliente;
  
  public ClienteDTO() { }    
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getNombreUsuario() {
    return nombreUsuario;
  }

  public String getClave() {
    return clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
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
  
  public String getDomicilio() {
    return domicilio;
  }

  public void setDomicilio(String domicilio) {
    this.domicilio = domicilio;
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

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}
  
  public boolean getEsTitular() {  	
  	return this.id_cliente == null;
  }
}
