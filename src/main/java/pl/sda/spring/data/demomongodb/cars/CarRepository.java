package pl.sda.spring.data.demomongodb.cars;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends MongoRepository<Car, Long> {

    List<Car> findByBrandLike(@Param("brand") String brand);
}
