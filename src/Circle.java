/**
 * FileName: Circle.java
 * Assessment: SENG2200 - A2
 * Author: Yosiah de Koeyer
 * Student No: c3329520
 * <p>
 * Description:
 * Circle class that extends PlanarShape abstract class, used to represent a Circle
 */

public class Circle extends PlanarShape{
    private double radius;                      // radius of circle

    /**
     * Constructor when no args are given
     */
    public Circle() {
        super(ShapeType.CIRCLE, 1);
    }

    /**
     * Constructor when radius is given
     *
     * @param inRadius radius of circle
     */
    public Circle(int inRadius) {
        this();
        this.radius = inRadius;
    }

    /**
     * Constructor when radius and center are given
     *
     * @param inX x coord of center
     * @param inY y coord of center
     * @param inRadius radius of circle
     */
    public Circle(int inX, int inY, int inRadius) {
        this(inRadius);
        this.addPoint(inX, inY);
    }

    /**
     * toString() method
     *
     * @return A string representation of the circle
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("CIRC=[");
        for (Point p : super.points) {
            str.append(p);
        }
        str.append(String.format(" %3.2f]: %5.2f",this.radius, this.area()));
        return str.toString();
    }

    /**
     * area() method
     *
     * @return the area of the circle
     */
    @Override
    public double area() {
        return (Math.PI * Math.pow(radius, 2));
    }

    /**
     * originDistance() method
     *
     * @return the distance from the closest point on the perimeter of the circle
     */
    @Override
    public double originDistance() {
        return this.points[0].distFromOrigin() - radius;
    }

    /**
     * getRadius() method
     *
     * @return the radius of the circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * setRadius() method
     *
     * @param radius radius to set for the circle
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
}
