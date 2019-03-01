package pl.sda.spring.data.demomongodb.cars;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car, Long> {
}
