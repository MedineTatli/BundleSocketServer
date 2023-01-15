package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@EnableScheduling
public class BundleSocketServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(main.BundleSocketServerApplication.class, args);
    }

}
