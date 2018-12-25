package bankaKupca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BankaKupcaApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankaKupcaApplication.class, args);
    }
}
