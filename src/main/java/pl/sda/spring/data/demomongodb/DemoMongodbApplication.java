package pl.sda.spring.data.demomongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class DemoMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMongodbApplication.class, args);
	}

}
