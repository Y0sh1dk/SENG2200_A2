/**
 * FileName: SemiCircle.java
 * Assessment: SENG2200 - A2
 * Author: Yosiah de Koeyer
 * Student No: c3329520
 * <p>
 * Description:
 * SemiCircle class that expends the PlanarShape abstract class, used to represent a semi-circle
 */

public class SemiCircle extends PlanarShape{

    public SemiCircle() {
        super(ShapeType.SEMICIRCLE, 2);
    }

    public SemiCircle(int inX1, int inY1, int inX2, int inY2) {
        this();
        addPoint(inX1, inY1);
        addPoint(inX2, inY2);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("SEMI=[");
        for (Point p : this.points) {
            str.append(p);
        }
        str.append(String.format("]: %5.2f", this.area()));
        return str.toString();
    }

    @Override
    public double area() {
        return (Math.PI * Math.pow(this.radius(), 2))/2;
    }

    @Override
    public double originDistance() {
        // Probs a better way lmao
        Point[] consideredPoints = new Point[4];
        consideredPoints[0] = this.points[0];
        consideredPoints[1] = this.points[1];
        consideredPoints[2] = new Point(
                this.points[0].getX() - Math.abs(this.points[0].getY() - this.points[1].getY()),
                this.points[0].getY() + Math.abs(this.points[0].getX() - this.points[1].getX())
        );
        consideredPoints[3] = new Point(
                this.points[0].getX() + Math.abs(this.points[0].getY() - this.points[1].getY()),
                this.points[0].getY() - Math.abs(this.points[0].getX() - this.points[1].getX())
        );

        double shortestDist = consideredPoints[0].distFromOrigin();
        for (Point p : consideredPoints) {
            if (p.distFromOrigin() < shortestDist) {
                shortestDist = p.distFromOrigin();
            }
        }
        return shortestDist;
    }

    public double radius() {
        return this.points[0].distFromPoint(this.points[1]);
    }
}
