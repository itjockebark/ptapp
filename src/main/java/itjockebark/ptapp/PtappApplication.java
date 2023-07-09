package itjockebark.ptapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PtappApplication {

    public static void main(String[] args) {
        SpringApplication.run(PtappApplication.class, args);
    }

}
