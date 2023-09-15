/**
 * Rectangle class that extends Shape
 */
public class Rectangle extends Shape {
    private double length, width;

    /**
     * default constructor
     * sets length and width to 1.0
     */
    public Rectangle() {
        super();
        length = width = 1.0;
    }

    /**
     * constructor with parameters
     * @param l length
     * @param w width
     * @param c color
     */
    public Rectangle(String c, double l, double w) {
        super(c);
        length = l;
        width = w;
    }

    /**
     * getter method for length
     * @return length
     */
    public double getLength() {
        return length;
    }

    /**
     * getter method for width
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * setter method for length
     * @param l length
     */
    public void setLength(double l) {
        length = l;
    }

    /**
     * setter method for width
     * @param w width
     */
    public void setWidth(double w) {
        width = w;
    }

    /**
     * calculates area
     * @return area
     */
    public double getArea() {
        return length * width;
    }

    /**
     * calculates perimeter
     * @return perimeter
     */
    public double getPerimeter() {
        return 2 * (length + width);
    }

    /**
     * clones the object
     * @return cloned object
     */
    public Object clone() {
        return new Rectangle(getColor(), length, width);
    }

    /**
     * scales the object
     * @param f factor
     */
    public void scale(double f) {
        length *= f;
        width *= f;
    }

    /**
     * toString method
     * @return string representation of the object
     */
    public String toString() {
        return "Rectangle\t" + getColor() + "\t" + length + "\t" + width + "\t\t" +
            getArea() + "\t" + getPerimeter();
    }


}