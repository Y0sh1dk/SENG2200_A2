import java.util.ArrayList;

public abstract class PlanarShape implements Comparable<PlanarShape> {
    enum ShapeType {
        POLYGON,
        CIRCLE,
        SEMICIRCLE,
    }

    private PlanarShape.ShapeType shapeType;
    protected ArrayList<Point> points;

    public PlanarShape(ShapeType shapeType) {
        this.shapeType = shapeType;
        this.points = new ArrayList<>();
    }

    @Override
    public int compareTo(PlanarShape o) {
        return 0;
    }

    @Override
    public abstract String toString();

    public abstract double area();

    public abstract double originDistance();
}
