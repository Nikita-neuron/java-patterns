package practice_7.composite;

public class SportCar implements Car{
    @Override
    public void draw(String color) {
        System.out.println("Draw SportClass with color: " + color);
    }
}
