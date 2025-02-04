package matsbak.app.passnav_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

/**
 * The PassnavApiApplication class represents the runner class for the application.
 * 
 * @author Mats Bakketeig
 * @version v0.0.1 (2025.02.04)
 */
@SpringBootApplication
public class PassnavApiApplication {
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(PassnavApiApplication.class);
		springApplication.addListeners(new ApplicationPidFileWriter("passnav.pid"));
		SpringApplication.run(PassnavApiApplication.class, args);
	}
}
