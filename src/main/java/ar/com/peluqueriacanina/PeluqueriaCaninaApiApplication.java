package ar.com.peluqueriacanina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ar.com.peluqueriacanina")
public class PeluqueriaCaninaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeluqueriaCaninaApiApplication.class, args);
	}

}
