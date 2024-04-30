package ee.tlu.salat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalatApplication.class, args);
	}

}


// Veakoodid:
// 404 - URL või API on vale
// 4xx - front end viga
// 5xx - back end viga