package ms.hotlinebling.hotlineblingdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HotlineblingDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotlineblingDiscoveryApplication.class, args);
	}

}

/*
 * @EnableEurekaServer
 * - marks the application as a Eureka Server 
 * 
 * 
 * - having both eureka-server and eureka-client
 * 	 both enabled in pom.xml prevents the application 
 * 	 from starting successfully.  
 * */
