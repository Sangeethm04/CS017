/**
 * TestShapes class 
 */
public class TestShapes {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[8];
        shapes[0] = new Circle("Black", 2.5);
        shapes[1] = new Triangle("Green", 6.0, 6.0, 6.0);
        shapes[2] = new Rectangle("Red", 5.0, 3.0);
        shapes[3] = new Pentagon("Yellow", 7.0);

        shapes[4] = (Shape)(shapes[0].clone()); //cloning the circle
        shapes[5] = (Shape)(shapes[1].clone()); //cloning the triangle
        shapes[6] = (Shape)(shapes[2].clone()); //cloning the rectangle
        shapes[7] = (Shape)(shapes[3].clone()); //cloning the pentagon

        shapes[4].scale(2.0);
        shapes[5].setColor("Orange");
        ((Rectangle) shapes[6]).setLength(10.0);
        ((Pentagon) shapes[7]).setSide(4.0);


        System.out.println("Before sorting");
        System.out.println("Shape\t\t" + "Color\t" + "Dimensions\t\t" + "Area\t" + "Perimeter");
        printShapes(shapes);
        System.out.println();
        System.out.println("After sorting");
        System.out.println("Shape\t\t" + "Color\t" + "Dimensions\t\t" + "Area\t" + "Perimeter");
        java.util.Arrays.sort(shapes);
        printShapes(shapes);
        System.out.println();
        System.out.println("Average Perimeter = " + getAveragePerimeter(shapes));


    }

    /**
     * static printShapes method
     * @param list list of shapes
     */
    public static void printShapes(Shape[] list) {
        for (Shape s: list) {
            System.out.println(s);
        }
    }

    /**
     * static getAveragePerimeter method
     * @param list list of shapes
     * @return average perimeter
     */
    public static double getAveragePerimeter(Shape[] list) {
        double total = 0;
        for (int i = 0; i < list.length; i++) {
            total += list[i].getPerimeter();
        }
        return Math.round((total / list.length) * 100.0) / 100.0;

    }
}