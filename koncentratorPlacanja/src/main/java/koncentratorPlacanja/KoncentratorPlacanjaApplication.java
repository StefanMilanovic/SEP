package koncentratorPlacanja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class KoncentratorPlacanjaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KoncentratorPlacanjaApplication.class, args);
    }
}