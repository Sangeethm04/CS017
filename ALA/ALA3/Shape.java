public abstract class Shape implements Cloneable, Scalable, Comparable<Shape> {
    String color;

    protected Shape() {
        color = "none";
    }

    protected Shape(String c) {
        color = c;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String c) {
        color=c;
    }

    public abstract double getArea();

    public abstract double getPerimeter();


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

    public abstract Object clone();

    public String toString() {
        return color;
    }

}
