package atletismo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context= SpringApplication.run(DemoApplication.class, args);
		context.getBean(AtletaService.class).testAtleta();
		context.getBean(MedallasService.class).testMedalla();
	}
}
