public abstract class PlanarShape {
    private ShapeType shapeType;

    @Override
    public abstract String toString();

    public abstract double area();

    public abstract double originDistance();
}
