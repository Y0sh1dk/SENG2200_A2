public class PlanarShapeFactory {

    public static PlanarShape getShape(PlanarShape.ShapeType inShapeType) throws Exception {
        return generateShape(inShapeType, -1);
    }

    public static PlanarShape getShape(PlanarShape.ShapeType inShapeType, int inNumOfSides) throws Exception {
        return generateShape(inShapeType, inNumOfSides);
    }

    private static PlanarShape generateShape(PlanarShape.ShapeType inShapeType, int inNumOfSides) throws Exception {
        if( inNumOfSides <= 0) {
            if (inShapeType == PlanarShape.ShapeType.POLYGON) {
                throw new Exception("Cannot create: " + inShapeType + " - Number of points not given");
            }
        }

        if(inShapeType == PlanarShape.ShapeType.CIRCLE) {
            return new Circle();
        } else if (inShapeType == PlanarShape.ShapeType.POLYGON) {
            return new Polygon(inNumOfSides);
        } else if (inShapeType == PlanarShape.ShapeType.SEMICIRCLE) {
            return new SemiCircle();
        }
        throw new Exception("Cannot create: " + inShapeType);
    }
}
