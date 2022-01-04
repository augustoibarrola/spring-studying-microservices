package ms.hotlinebling.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@EnableDiscoveryClient
public class HotlineblingCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotlineblingCustomerApplication.class, args);
	}

}

/* @EnableDiscoveryClient
 * 		- marks an application as both a Eureka instance and a Eureka client.  
 * 
 */
