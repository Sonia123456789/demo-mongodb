package pl.sda.spring.data.demomongodb.cars;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {

    Long id;
    String brand;
    String model;
    int hp;
    int capacity;
}
