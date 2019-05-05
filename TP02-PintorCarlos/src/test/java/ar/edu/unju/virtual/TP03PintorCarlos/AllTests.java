package ar.edu.unju.virtual.TP03PintorCarlos;

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
  RolTest.class,
  FrontServiceTest.class})
public class AllTests { }
