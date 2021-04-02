public class Circle extends PlanarShape{
    private double radius;

    public Circle() {
        super(ShapeType.CIRCLE);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("CIRC=[");
        for (Point p : super.points) {
            str.append(p);
        }
        str.append(String.format("%3.2f]:  %5.2f",this.radius, this.area()));
        return str.toString();
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double originDistance() {
        return 0;
    }
}
