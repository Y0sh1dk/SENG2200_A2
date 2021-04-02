public class PlanarShapeFactory {

    public static PlanarShape getShape(PlanarShape.ShapeType inShapeType) {
        if(inShapeType == PlanarShape.ShapeType.CIRCLE) {
            return new Circle();
        } else if (inShapeType == PlanarShape.ShapeType.POLYGON) {
            return new Polygon();
        } else if (inShapeType == PlanarShape.ShapeType.SEMICIRCLE) {
            return new SemiCircle();
        } else {
            return null;
        }
    }
}
