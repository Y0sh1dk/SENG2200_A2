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
        double a = 0;
        for (int i = 0; i <= (points.size() - 2); i++) {
            a += ((points.get(i + 1).getxCoordinate() + points.get(i).getxCoordinate()) *
                    (points.get(i + 1).getyCoordinate() - points.get(i).getyCoordinate()));
        }
        // for the last calculation that needs to use the first and last point
        a += ((points.get(0).getxCoordinate() + points.get(points.size() - 1).getxCoordinate()) *
                (points.get(0).getyCoordinate() - points.get(points.size() - 1).getyCoordinate()));
        return 0.5 * Math.abs(a);
    }

    @Override
    public double originDistance() {
        return 0;
    }
}
