import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Scanner;

/**
 * FileName: PA2.java
 * Assessment: SENG2200 - A2
 * Author: Yosiah de Koeyer
 * Student No: c3329520
 * <p>
 * Description:
 * Main class file for A2, accepts a file path from the command line args and generates and inserts polygons into
 * a CLL.
 */

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
    private void run(Path filePath) {
        System.out.println("Unsorted list");
        LinkedList<PlanarShape> l1 = new LinkedList<>();             // Create new MyPolygons instance
        this.generateShapesFromFile(filePath, l1);                   // Add polygons from file
        System.out.print(l1);                                        // Print string rep of class

        LinkedList<PlanarShape> l2 = new LinkedList<>();             // Create new MyPolygons instance
        Iterator<PlanarShape> itr = l1.iterator();
        while(itr.hasNext()) {
            l2.insertInOrder(itr.next());
            itr.remove();
        }
        System.out.println("Sorted list");
        System.out.println(l2);                                      // Print string rep of class
    }

    /**
     * generateShapesFromFile() method
     *
     * @param filePath path to the file to read shapes from
     * @param inLL LL to add the shapes too
     */
    private void generateShapesFromFile(Path filePath, LinkedList<PlanarShape> inLL) {
        try {
            Scanner inputStream = new Scanner(Path.of(String.valueOf(filePath.toAbsolutePath())));  // open file
            inputStream.useDelimiter("P|C|S");
            while(inputStream.hasNext()) {
                switch (inputStream.findInLine("P|C|S")) {
                    case "P":
                        inLL.append(PlanarShapeFactory.getShape(PlanarShape.ShapeType.POLYGON, inputStream.next()));
                        break;
                    case "C":
                        inLL.append(PlanarShapeFactory.getShape(PlanarShape.ShapeType.CIRCLE, inputStream.next()));
                        break;
                    case "S":
                        inLL.append(PlanarShapeFactory.getShape(PlanarShape.ShapeType.SEMICIRCLE, inputStream.next()));
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}