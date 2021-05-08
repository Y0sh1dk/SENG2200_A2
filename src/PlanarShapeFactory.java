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
     * @param shapeStr string of params to create the shape
     * @return the created shape
     * @throws Exception an exception if shape cannot be created
     */
    public static PlanarShape getShape(PlanarShape.ShapeType inShapeType, String shapeStr) throws Exception {
        switch (inShapeType) {
            case POLYGON -> {
                return generatePolygon(shapeStr);
            }
            case CIRCLE -> {
                return generateCircle(shapeStr);
            }
            case SEMICIRCLE -> {
                return generateSemiCircle(shapeStr);
            }
            default -> {
                throw new Exception("Cannot create from string: " + shapeStr);
            }
        }
    }

    /**
     * generatePolygon() method
     * @param shapeStr string containing parameters for creating a polygon
     * @return a polygon object with parameters set
     */
    private static PlanarShape generatePolygon(String shapeStr) {
        String[] params = shapeStr.trim().split("\\s+");
        Polygon poly = new Polygon(Integer.parseInt(params[0]));
        for (int i = 1; i < Integer.parseInt(params[0]) * 2; i = i+2) {
            poly.addPoint(Double.parseDouble(params[i]), Double.parseDouble(params[i+1]));
        }
        return poly;
    }

    /**
     * generateCircle() method
     * @param shapeStr string containing parameters for creating a circle
     * @return a circle object with parameters set
     */
    private static PlanarShape generateCircle(String shapeStr) {
        String[] params = shapeStr.trim().split("\\s+");
        Circle circle = new Circle();
        circle.addPoint(Double.parseDouble(params[0]), Double.parseDouble(params[1]));
        circle.setRadius(Double.parseDouble(params[2]));
        return circle;
    }

    /**
     * generateSemiCircle() method
     * @param shapeStr string containing parameters for creating a Semicircle
     * @return a SemiCircle object with parameters set
     */
    private static PlanarShape generateSemiCircle(String shapeStr) {
        String[] params = shapeStr.trim().split("\\s+");
        SemiCircle semiCircle = new SemiCircle();
        semiCircle.addPoint(Double.parseDouble(params[0]), Double.parseDouble(params[1]));
        semiCircle.addPoint(Double.parseDouble(params[2]), Double.parseDouble(params[3]));
        return semiCircle;
    }
}
