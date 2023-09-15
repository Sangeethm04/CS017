/**
 * Triangle class which extends shape
 */
public class Triangle extends Shape {
    private double side1, side2, side3;

    /**
     * default constructor
     * sets sides to 1.0
     */
    public Triangle() {
        super();
        side1 = side2 = side3 = 1.0;
    }

    /**
     * constructor with parameters side lengths, color
     * @param c color
     * @param s1 side 1
     * @param s2 side 2
     * @param s3 side 3
     */
    public Triangle(String c, double s1, double s2, double s3) {
        super(c);
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    /**
     * public side getter
     * @return side length
     */
    public double getSide1() {
        return side1;
    }

    /**
     * public side getter
     * @return side length
     */
    public double getSide2() {
        return side1;
    }

    /**
     * public side getter
     * @return side length
     */
    public double getSide3() {
        return side1;
    }

    /**
     * public side setter
     * @param s1 side length
     */
    public void setSide1(double s1) {
        side1 = s1;
    }

    /**
     * public side setter
     * @param s2 side length
     */
    public void setSide2(double s2) {
        side2 = s2;
    }

    /**
     * public side setter
     * @param s3 side length
     */
    public void setSide3(double s3) {
        side3 = s3;
    }


    /**
     * calculates area
     * @return area
     */
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.round((Math.sqrt(p * (p - side1) * (p - side2) * (p - side3))) * 100.0) / 100.0;

    }

    /**
     * calculates perimeter
     * @return perimeter
     */
    public double getPerimeter() {
        return Math.round((side1 + side2 + side3) * 100.0) / 100.0;

    }

    /**
     * deep clones traingle object
     * @return object
     */
    public Object clone() {
        return new Triangle(getColor(), side1, side2, side3);
    }

    /**
     * scales triangle by factor f
     */
    public void scale(double f) {
        side1 *= f;
        side2 *= f;
        side3 *= f;
    }

    /**
     * toString method
     * @return String color of shape
     */
    public String toString() {
        return "Triangle\t" + getColor() + "\t" + side1 + "\t" + side2 + "\t" + side3 + "\t" +
            getArea() + "\t" + getPerimeter();
    }

}