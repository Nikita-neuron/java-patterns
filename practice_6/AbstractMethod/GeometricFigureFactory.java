package practice_6.AbstractMethod;

public class GeometricFigureFactory implements GeometricFigureAbstractFactory{
    @Override
    public GeometricFigure createGeometricFigure(GeometricFigureType type) {
        GeometricFigure geometricFigure = null;
        switch (type) {
            case RECTANGLE:
                geometricFigure = new Rectangle();
                break;
            case CIRCLE:
                geometricFigure = new Circle();
                break;
        }
        return geometricFigure;
    }
}
