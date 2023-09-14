/**
 * Circle class
 * 
 */
public class Circle extends Shape {
    double radius;

    /**
     * Constructor for objects of class Circle
     */
    public Circle() {
        super();
        radius = 1.0;
    }

    /**
     * Constructor for objects of class Circle
     * @param c
     * @param r
     */
    public Circle(String c, double r) {
        super(c);
        radius = r;
    }

    /**
     * Getter for radius
     * @return
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Setter for radius
     * @param r
     */
    public void setRadius(double r) {
        radius = r; 
    }
    
    /**
     * Calculates the area of the circle
     * @return double area
     */
    public double getArea() {
        return Math.round((Math.PI * radius * radius) * 100.0) / 100.0;
    }

    /**
     * Calculates the perimeter of the circle
     * @return double perimeter
     */
    public double getPerimeter() {
       return Math.round((2 * Math.PI * radius) * 100.0) / 100.0;
    }

    /**
     * Clones the circle
     * @return Object
     */
    public Object clone() {
        return new Circle(getColor(), radius);
    }

    /**
     * Scales the circle
     * @param f scale factor
     */
    public void scale(double f) {
        radius *= f;
    }

    /**
     * Returns a string attributes of circle
     * @return String
     */
    public String toString() {
        return "Circle\t\t" + getColor() + "\t" + radius + "\t\t\t" + 
                getArea() + "\t" + getPerimeter();
    }
}
