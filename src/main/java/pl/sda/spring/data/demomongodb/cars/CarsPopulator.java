package pl.sda.spring.data.demomongodb.cars;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CarsPopulator implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CarsPopulator.class);

    @Autowired
    CarRepository carRepository;

    @Override
    public void run(String...args) throws Exception {
        Car car = Car.builder()
                .id(1L)
                .brand("Ferrari")
                .model("812 Superfast")
                .hp(800)
                .capacity(6500)
                .build();
        Car car2 = Car.builder()
                .id(2L)
                .brand("Fiat")
                .model("126p")
                .hp(23)
                .capacity(650)
                .build();

        carRepository.insert(car);
        carRepository.insert(car2);
    }

}