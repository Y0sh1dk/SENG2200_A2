/**
 * FileName: PlanarShape.java
 * Assessment: SENG2200 - A2
 * Author: Yosiah de Koeyer
 * Student No: c3329520
 * <p>
 * Description:
 * PlanarShape abstract class, base class for all other shape classes
 */

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
        // 1 if current object is grater than the specified object
        // -1 if the current object is less than the specified object
        // 0 if the current object is equal to the specified object

        double inPolyArea = o.area();
        double thisPolyArea = this.area();

        PlanarShape smallestPoly;
        if (inPolyArea > thisPolyArea) {
            smallestPoly = this;
        } else {
            smallestPoly = o;
        }

        // If within 0.05% of each other TODO: tests this
        if (Math.abs(inPolyArea - thisPolyArea) <= (0.0005 * smallestPoly.area())) {
            return this.originDistance() < o.originDistance() ? 1 : -1;
        }
        return this.area() > o.area() ? 1 : -1;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }


    @Override
    public abstract String toString();

    public abstract double area();

    public abstract double originDistance();
}
