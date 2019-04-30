package ar.edu.unju.virtual.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cliente;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Cuenta;
import ar.edu.unju.virtual.TP02PintorCarlos.model.entity.Movimiento;

public class Util {
  
  public static Cliente getCliente() {
    return new Cliente(
      12345678L,
      "john.doe",
      "j0hn.d03",
      "John Doe",
      "120 Redberry Road",
      "john.doe@hotmail.com",
      "HABILITADO"
    );    
  }
  
  public static Cuenta getCuenta(Cliente cliente) {
    return new Cuenta(
      "11111111111111111111",
      Util.getTimestamp("2019-01-01"),
      50000d,
      "HABILITADO",
      5000l,
      cliente
    );
  }
  
  public static Movimiento getMovimiento(Cuenta cuenta, Cliente cliente) {
    return new Movimiento(
      cuenta,
      Util.getTimestamp("2019-01-01"),
      0d,
      17000d,
      34000d,
      cliente
    );
  }
  
  public static Timestamp getTimestamp(String dateString) {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;
    Timestamp tstamp = null;
    
    try {
      date = df.parse(dateString);
      tstamp = new java.sql.Timestamp(date.getTime());
    } catch (ParseException e) {
      e.printStackTrace(); 
    }
    
    return tstamp;
  }
}
