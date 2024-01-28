package spring.citiesmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CitiesMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CitiesMicroserviceApplication.class, args);
    }

}
