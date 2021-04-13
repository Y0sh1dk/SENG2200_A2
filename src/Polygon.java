/**
 * FileName: Polygon.java
 * Assessment: SENG2200 - A2
 * Author: Yosiah de Koeyer
 * Student No: c3329520
 * <p>
 * Description:
 * Polygon class that extends the PlanarShape abstract class, used to reporesent a Polygon
 */

public class Polygon extends PlanarShape {

    public Polygon(int inNumOfPoints) {
        super(ShapeType.POLYGON, inNumOfPoints);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("POLY=[");
        for (Point p : super.points) {
            str.append(p);
        }
        str.append(String.format("]: %5.2f", this.area()));
        return str.toString();
    }

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

    @Override
    public double originDistance() { // TODO: CHECK THIS!!!
        double shortestDist = this.points[0].distFromOrigin(); // Initialize with any value from the array
        for (Point p : this.points) {
            if (p.distFromOrigin() < shortestDist) {
                shortestDist = p.distFromOrigin();
            }
        }
        return shortestDist;
    }
}
