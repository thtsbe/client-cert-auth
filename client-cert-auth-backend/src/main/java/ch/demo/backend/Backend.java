package ch.demo.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * http://localhost:12000/api/demo
 */
@SpringBootApplication
public class Backend {

    public static void main(String[] args) {
        SpringApplication.run(Backend.class, args);
    }

}