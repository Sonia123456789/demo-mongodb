package pl.sda.spring.data.demomongodb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.spring.data.demomongodb.cars.Car;
import pl.sda.spring.data.demomongodb.cars.CarRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoMongodbApplicationTests {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	CarRepository mongoRepository;

	@Test
	public void testTemplate() {
		Car car = Car.builder()
				.id(10L)
				.brand("Ferrari")
				.model("812 Superfast")
				.hp(800)
				.capacity(6500)
				.build();
		mongoTemplate.insert(car);

		System.out.println("====");
		mongoTemplate.findAll(Car.class).forEach(t -> System.out.println(t.toString()));

		System.out.println("====");

		mongoRepository.findAll().forEach(t -> System.out.println(t.toString()));
		System.out.println("====");
	}

}
