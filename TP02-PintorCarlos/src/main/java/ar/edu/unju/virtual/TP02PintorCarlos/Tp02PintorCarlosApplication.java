package ar.edu.unju.virtual.TP02PintorCarlos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tp02PintorCarlosApplication {
  private static final Logger LOG = LoggerFactory.getLogger(Tp02PintorCarlosApplication.class);

	public static void main(String[] args) {
	  
		SpringApplication.run(Tp02PintorCarlosApplication.class, args);
		
		LOG.info("Logger INFO");
	}

}
