package ch.demo.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * https://localhost:12000/api/demo
 *
 * ./ssl/keystore.jks
 *      Contains server certificate signed by root CA
 *
 * ./auth/truststore.jks
 *      Contains truststore that accepts certificates signed by root CA
 */
@SpringBootApplication
public class Backend {

    public static void main(String[] args) {
        SpringApplication.run(Backend.class, args);
    }

}
