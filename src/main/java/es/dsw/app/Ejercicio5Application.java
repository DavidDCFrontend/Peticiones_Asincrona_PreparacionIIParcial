package es.dsw.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"es.dsw"})
public class Ejercicio5Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio5Application.class, args);
	}

}
