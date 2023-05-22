package practice_7.composite;

public class UnknownCar implements Car{
    @Override
    public void draw(String color) {
        System.out.println("Draw UnknownCar with color: " + color);
    }
}
