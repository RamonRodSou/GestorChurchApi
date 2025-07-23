package br.com.technosou.gestor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.technosou.gestor")
public class GestorApplication {

	public static void main(String[] args) {

		SpringApplication.run(GestorApplication.class, args);
	}

}
