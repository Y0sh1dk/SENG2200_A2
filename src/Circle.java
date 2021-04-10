public class Circle extends PlanarShape{
    private double radius;

    public Circle() {
        super(ShapeType.CIRCLE, 1);
    }

    public Circle(int inRadius) {
        this();
        this.radius = inRadius;
    }

    public Circle(int inX, int inY, int inRadius) {
        this(inRadius);
        this.addPoint(inX, inY);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("CIRC=[");
        for (Point p : super.points) {
            str.append(p);
        }
        str.append(String.format(" %3.2f]:  %5.2f",this.radius, this.area()));
        return str.toString();
    }

    @Override
    public double area() {
        return (Math.PI * Math.pow(radius, 2));
    }

    @Override
    public double originDistance() {
        return this.points[0].distFromOrigin() - radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
