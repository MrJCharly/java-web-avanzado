package ar.edu.unju.virtual.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ar.edu.unju.virtual.TP02PintorCarlos.Tp02PintorCarlosApplicationTests;

@RunWith(Suite.class)
@SuiteClasses({ 
  Tp02PintorCarlosApplicationTests.class, 
  ClienteTest.class,
  CuentaTest.class,
  MovimientoTest.class, 
  RolTest.class })
public class AllTests {

}
