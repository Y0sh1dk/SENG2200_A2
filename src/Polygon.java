/**
 * FileName: Polygon.java
 * Assessment: SENG2200 - A2
 * Author: Yosiah de Koeyer
 * Student No: c3329520
 * <p>
 * Description:
 * Polygon class that extends the PlanarShape abstract class, used to represent a Polygon
 */

public class Polygon extends PlanarShape {

    /**
     * Constructor when number of points are given
     * @param inNumOfPoints number of points on the polygon
     */
    public Polygon(int inNumOfPoints) {
        super(ShapeType.POLYGON, inNumOfPoints);
    }

    /**
     * toString() method
     * @return A string representation of the polygon
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("POLY=[");
        for (Point p : super.points) {
            str.append(p);
        }
        str.append(String.format("]: %5.2f", this.area()));
        return str.toString();
    }

    /**
     * area() method
     * @return the area of the polygon
     */
    @Override
    public double area() {
        double a = 0;
        for (int i = 0; i <= (points.length - 2); i++) {
            a += ((points[i + 1].getX() + points[i].getX()) *
                    (points[i + 1].getY() - points[i].getY()));
        }
        // for the last calculation that needs to use the first and last point
        a += ((points[0].getX() + points[points.length - 1].getX()) *
                (points[0].getY() - points[points.length - 1].getY()));
        return 0.5 * Math.abs(a);
    }

    /**
     * originDistance()
     * @return the distance from the closest point to the origin
     */
    @Override
    public double originDistance() {
        double shortestDist = this.points[0].distFromOrigin(); // Initialize with any value from the array
        for (Point p : this.points) {
            if (p.distFromOrigin() < shortestDist) {
                shortestDist = p.distFromOrigin();
            }
        }
        return shortestDist;
    }
}
