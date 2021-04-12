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
        for (Point p : super.points) {
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
        return 0;
    }

    public double radius() {
        return points[0].distFromPoint(points[1]);
    }
}
