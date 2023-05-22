package practice_7.composite;

import java.util.ArrayList;

public class CarCanvas {
    private ArrayList<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void draw(String color) {
        for (Car car : cars) {
            car.draw(color);
        }
    }
}
