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
        str.append(String.format("]:  %5.2f", this.area()));
        return str.toString();
    }

    @Override
    public double area() {
        double a = 0;
        for (int i = 0; i <= (points.length - 2); i++) {
            a += ((points[i + 1].getxCoordinate() + points[i].getxCoordinate()) *
                    (points[i + 1].getyCoordinate() - points[i].getyCoordinate()));
        }
        // for the last calculation that needs to use the first and last point
        a += ((points[0].getxCoordinate() + points[points.length - 1].getxCoordinate()) *
                (points[0].getyCoordinate() - points[points.length - 1].getyCoordinate()));
        return 0.5 * Math.abs(a);
    }

    @Override
    public double originDistance() {
        return 0;
    }
}
