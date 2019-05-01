package ar.edu.unju.virtual.TP02PintorCarlos.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name="clientes")
public class Cliente {
  
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="clientes_id_seq")
  @SequenceGenerator(sequenceName="clientes_id_seq", allocationSize=1, name="clientes_id_seq")
  private Long id;
  
  private Long dni;
  
  @Column(name="nombre_usuario")
  private String nombreUsuario;
  
  private String clave;
  private String nombre;
  private String domicilio;
  private String email;
  private String estado;   

  @OneToMany(mappedBy="titular", fetch=FetchType.EAGER)
  private List<Cuenta> cuentas;
  
  @ManyToOne
  @JoinColumn(name="rol_id", nullable = false)
  private Rol rol;
  
  public Cliente() {
    
  }
  
  public Cliente(Long dni, String nombreUsuario, String clave, String nombre, String domicilio, String email,
      String estado, Rol rol) {
    super();
    this.dni = dni;
    this.nombreUsuario = nombreUsuario;
    this.clave = clave;
    this.nombre = nombre;
    this.domicilio = domicilio;
    this.email = email;
    this.estado = estado;
    this.rol = rol;
  }

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
  
  public String getNombre() {
    return nombre;
  }
  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  public String getDomicilio() {
    return domicilio;
  }
  
  public void setDomicilio(String domicilio) {
    this.domicilio = domicilio;
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

  public List<Cuenta> getCuentas() {
    return cuentas;
  }

  public Rol getRol() {
    return rol;
  }

  public void setRol(Rol rol) {
    this.rol = rol;
  }

  @Override
  public String toString() {
    return "Cliente [id=" + id + ", dni=" + dni + ", nombreUsuario=" + nombreUsuario + ", clave=" + clave + ", nombre="
        + nombre + ", domicilio=" + domicilio + ", email=" + email + ", estado=" + estado + ", cuentas=" + cuentas
        + ", rol=" + rol + "]";
  }
  
}
