public class Polygon extends PlanarShape {

    public Polygon() {
        super(ShapeType.POLYGON);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("POLY=[");
        for (Point p : super.points) {
            str.append(p);
        }
        str.append(String.format("]:  %5.2f", this.area()));
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
