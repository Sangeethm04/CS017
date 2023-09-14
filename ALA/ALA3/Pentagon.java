/**
 * Pentagon class
 */
public class Pentagon extends Shape {
    double side;

    /**
     * Constructor for objects of class Pentagon
     */
    public Pentagon() {
        super();
        side = 1.0;
    }

    /**
     * Constructor for objects of class Pentagon
     * @param c
     * @param s
     */
    public Pentagon(String c, double s) {
        super(c);
        side = s;
    }

    /**
     * Getter for side
     * @return
     */
    public double getSide() {return side;}
    /**
     * Setter for side
     * @param s
     */
    public void setSide(double s) {side =s;}
    /**
     * Calculates the area of the pentagon
     * @return double area
     */
    public double getArea() {
        double c = 0.25 * Math.sqrt(5 * (5+2 *Math.sqrt(5)));
        return Math.round((c * side * side) * 100.0) / 100.0;
        
    }
    /**
     * Calculates the perimeter of the pentagon
     * @return double perimeter
     */
    public double getPerimeter() {
        return Math.round((5 * side)*100)/100;
    }
    /**
     * Clones the pentagon
     * @return Object
     */
    public Object clone() {
        return new Pentagon(getColor(), side);
    }
    /**
     * Scales the pentagon
     * @param f scale factor
     */
    public void scale(double f) {
        side *= f;
    }
    /**
     * Returns a string attributes of the pentagon
     * @return String
     */
    public String toString() {
        return "Pentagon\t" + getColor() + "\t" + side + "\t\t\t" + getArea() + "\t" + getPerimeter();
    }
}
