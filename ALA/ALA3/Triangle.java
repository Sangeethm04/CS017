public class Triangle extends Shape {
    private double side1, side2, side3;

    public Triangle() {
        super();
        side1 = side2 = side3 = 1.0;
    }

    public Triangle(String c, double s1, double s2, double s3) {
        super(c);
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    public double getSide1() {
        return side1;
    }
    public double getSide2() {
        return side1;
    }

    public double getSide3() {
        return side1;
    }

    // public setters

    public void setSide1(double s1) {
        side1 = s1;
    }
    public void setSide2(double s2) {
        side2 = s2;
    }

    public void setSide3(double s3) {
        side3 = s3;
    }



    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.round((Math.sqrt(p * (p - side1) * (p - side2) * (p - side3))) * 100.0) / 100.0;

    }

    public double getPerimeter() {
        return Math.round((side1 + side2 + side3) * 100.0) / 100.0;

    }

    public Object clone() {
        return new Triangle(getColor(), side1, side2, side3);
    }

    public void scale(double f) {
        side1 *= f;
        side2 *= f;
        side3 *= f;
    }

    public String toString() {
        return "Triangle\t" + getColor() + "\t" + side1 + "\t" + side2 + "\t" + side3 + "\t" +
            getArea() + "\t" + getPerimeter();
    }

}