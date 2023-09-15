/**
 * abstract class Shape that implements Scalable and Comparable and cloneable
 */
public abstract class Shape implements Cloneable, Scalable, Comparable<Shape> {
    String color;

    /**
     * default constructor
     */
    protected Shape() {
        color = "none";
    }

    /**
     * constructor with parameter
     * @param c color
     */
    protected Shape(String c) {
        color = c;
    }

    /**
     * getter method for color
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * setter method for color
     * @param c color
     */
    public void setColor(String c) {
        color=c;
    }

    /**
     * abstract getArea method
     * @return area
     */
    public abstract double getArea();

    /**
     * abstract getPerimeter method
     * @return perimeter
     */
    public abstract double getPerimeter();


    /**
     * compareto method for comparing shapes
     * @param s shape
     * @return 0 if equal, 1 if greater, -1 if less
     */
    public int compareTo(Shape s) {
        if(this.getArea() == (s.getArea())) {
            return 0;
        }
        else if(this.getArea() > s.getArea()) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * abstract clone method
     * @return object
     */
    public abstract Object clone();

    /**
     * toString method
     * @return String color of shape
     */
    public String toString() {
        return color;
    }

}
