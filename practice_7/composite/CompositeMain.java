package practice_7.composite;

public class CompositeMain {
    public static void main(String[] args) {
        Car sportCar = new SportCar();
        Car unknownCar = new UnknownCar();

        CarCanvas carCanvas = new CarCanvas();

        carCanvas.addCar(sportCar);
        carCanvas.addCar(unknownCar);
        carCanvas.draw("red");
    }
}
