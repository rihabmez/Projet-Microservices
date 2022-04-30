package fr.serviceregisteryclientcommandes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceRegisteryClientCommandesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegisteryClientCommandesApplication.class, args);
	}

}