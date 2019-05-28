package ar.edu.unju.virtual.TP02PintorCarlos.view.bean;

import javax.inject.Named;

@Named("clienteBean")
public class ClienteBean {
  private Long id;
	private Long dni;
	private String nombre;
	private String nombreUsuario;
	private String email;
	private String clave;
	private String domicilio;
	private String estado;
	private Long id_cliente;
	
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
	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
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

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	
}
