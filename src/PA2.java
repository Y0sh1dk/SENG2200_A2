import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * FileName: PA2.java
 * Assessment: SENG2200 - A1
 * Author: Yosiah de Koeyer
 * Student No: c3329520
 * <p>
 * Description:
 * Main class file for A1, accepts a file path from the command line args and generates and inserts polygons into
 * a CLL.
 */

// TODO: make getters/setters final!

public class PA2 {
    /**
     * Entry point method for PA2 class
     *
     * @param args takes params from cmd args
     */
    public static void main(String[] args) {
        if (args.length != 1) {                                     // If no args given, or too many args, exit
            System.out.println("Usage: PA2 [file]");
            return;
        }
        Path filePath = Path.of(args[0]);                           // first command line arg
        if (Files.exists(filePath)) {                               // If file exists, run
            PA2 main = new PA2();
            System.out.println("Using file: " + filePath);
            main.run(filePath);
        } else if (Files.exists(Path.of((filePath + ".txt")))) {    // If it doesnt, try adding '.txt' extension
            filePath = Path.of((filePath + ".txt"));
            PA2 main = new PA2();
            System.out.println("Using file: " + filePath);
            main.run(filePath);
        } else {                                                    // else no file can be found, exit
            System.out.println("File " + filePath.getFileName() + " is not found");
            System.out.println("Exiting...");
        }
    }

    /**
     * run() method
     *
     * @param filePath a path object generated from the input file
     */
    private void run(Path filePath) { //TODO: Iterator in here
        System.out.println("Unsorted list");
        LinkedList<PlanarShape> l1 = new LinkedList<>();                               // Create new MyPolygons instance
        this.generateShapesFromFile(filePath, l1);             // Add polygons from file
        System.out.println(l1);                                         // Print string rep of class

        LinkedList<PlanarShape> l2 = new LinkedList<>();                             // Create new MyPolygons instance
        int p1Size = l1.getSize();
        for (int i = 0; i < p1Size; i++) {
            //l2.insertInOrder(l1.take());
            l2.append(l1.take());
        }
        System.out.println("Sorted list");
        System.out.println(l2);                                         // Print string rep of class
    }

    /**
     * generatePolygonsFromFile() method
     *
     * @param filePath      a path object generated from the input file
     */
    private void generateShapesFromFile(Path filePath, LinkedList<PlanarShape> inLL) {
        try {
            Scanner inputStream = new Scanner(Path.of(String.valueOf(filePath.toAbsolutePath())));  // open file
            inputStream.useDelimiter("P|C|S");
            while(inputStream.hasNext()) {
                switch (inputStream.findInLine("P|C|S")) {
                    case "P":
                        inLL.append(generatePolygon(inputStream.next()));
                        break;
                    case "C":
                        inLL.append(generateCircle(inputStream.next()));
                        break;
                    case "S":
                        inLL.append(generateSemiCircle(inputStream.next()));
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private PlanarShape generatePolygon(String str) {
        String[] params = str.trim().split("\\s+");
        PlanarShape shape = null;
        try {
            shape = PlanarShapeFactory.getShape(PlanarShape.ShapeType.POLYGON, Integer.parseInt(params[0]));
            for (int i = 1; i < Integer.parseInt(params[0]) * 2; i = i+2) {
                shape.addPoint(Double.parseDouble(params[i]), Double.parseDouble(params[i+1]));
            }
        } catch (Exception e) {

        }
        return shape;
    }

    private Circle generateCircle(String str) {
        String[] params = str.trim().split("\\s+");
        Circle shape = null;
        try {
            shape = (Circle)PlanarShapeFactory.getShape(PlanarShape.ShapeType.CIRCLE);
            shape.addPoint(Double.parseDouble(params[0]), Double.parseDouble(params[1]));
            shape.setRadius(Double.parseDouble(params[2]));
        } catch (Exception e) {

        }
        return shape;
    }

    private SemiCircle generateSemiCircle(String str) {
        String[] params = str.trim().split("\\s+");
        SemiCircle shape = null;
        try {
            shape = (SemiCircle)PlanarShapeFactory.getShape(PlanarShape.ShapeType.SEMICIRCLE);
            shape.addPoint(Double.parseDouble(params[0]), Double.parseDouble(params[1]));
            shape.addPoint(Double.parseDouble(params[2]), Double.parseDouble(params[3]));
        } catch (Exception e) {

        }
        return shape;
    }



}