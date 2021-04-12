/**
 * FileName: PlanarShapeFactory.java
 * Assessment: SENG2200 - A2
 * Author: Yosiah de Koeyer
 * Student No: c3329520
 * <p>
 * Description:
 * PlanarShapeFactory, used to create shapes
 */
public class PlanarShapeFactory {

    /**
     * getShape() method
     * @param inShapeType type of shape to create
     * @return A shape object
     * @throws Exception if invalid shape type
     */
    public static PlanarShape getShape(PlanarShape.ShapeType inShapeType) throws Exception {
        return generateShape(inShapeType, -1);
    }

    /**
     * getShape() method
     * @param inShapeType type of shape to create
     * @param inNumOfSides Number of sides
     * @return A shape object
     * @throws Exception if invalid shape type or numOfSides
     */
    public static PlanarShape getShape(PlanarShape.ShapeType inShapeType, int inNumOfSides) throws Exception {
        return generateShape(inShapeType, inNumOfSides);
    }

    /**
     * generateShape() method
     * @param inShapeType type of shape to create
     * @param inNumOfSides Number of sides
     * @return A shape object
     * @throws Exception if invalid shape type or numOfSides
     */
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
