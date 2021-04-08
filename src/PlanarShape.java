import java.util.ArrayList;

public abstract class PlanarShape implements Comparable<PlanarShape> {
    enum ShapeType {
        POLYGON,
        CIRCLE,
        SEMICIRCLE,
    }

    private PlanarShape.ShapeType shapeType;
    protected Point[] points;
    protected int numOfPoints;

    public PlanarShape() {
        this.shapeType = null;
        this.numOfPoints = 0;
    }

    public PlanarShape(ShapeType shapeType, int inNumOfPoints) {
        this();
        this.shapeType = shapeType;
        this.points = new Point[inNumOfPoints];
    }

    /**
     * addPoint() method
     *
     * @param inXCoord x coord of new point
     * @param inYCoord y coord of new point
     */
    public void addPoint(double inXCoord, double inYCoord) {
        if (numOfPoints < points.length) {
            this.points[numOfPoints] = new Point(inXCoord, inYCoord);
            this.numOfPoints++; // increment number of points
        }
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
