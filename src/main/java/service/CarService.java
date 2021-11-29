package service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private List<Car> cars;
    public void setSameCars() {
        cars = new ArrayList<>(5);
        for(int i = 0; i < 5; i++) {
            cars.add(new Car("model" + i, i, "color" + i));
        }
    }
    public List<Car> getNeedCountCars(int count) {
        return (count >= 5) ? cars : cars.subList(0, count);
    }
}
