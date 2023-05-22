package practice_7.facade;

public class FacadeMain {
    public static void main(String[] args) {
        ShapeDraw shapeDraw = new ShapeDraw();

        shapeDraw.drawRectangle();
        shapeDraw.drawSquare();
        shapeDraw.drawCircle();
    }
}
