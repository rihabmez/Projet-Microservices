package fr.serviceregisteryclientproduits;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceRegisteryClientProduitsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegisteryClientProduitsApplication.class, args);
	}

}

// micro-service-1
@RestController
class ServiceInstanceRestController {

	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${server.port}")
	private String serverPort;

}