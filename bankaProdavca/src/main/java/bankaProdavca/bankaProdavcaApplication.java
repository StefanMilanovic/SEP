package bankaProdavca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class bankaProdavcaApplication {
    public static void main(String[] args) {
        SpringApplication.run(bankaProdavcaApplication.class, args);
    }
}
