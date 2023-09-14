public class Rectangle extends Shape {
    private double length, width;

    public Rectangle() {
        super();
        length = width = 1.0;
    }

    public Rectangle(String c, double l, double w) {
            super(c);
            length = l;
            width = w;
        }

        public double getLength() {
            return length;
        }
        public double getWidth() {
            return width;
        }
        public void setLength(double l) {
            length = l;
        }
        public void setWidth(double w) {
            width = w;
        }

        public double getArea() {
            return length * width;
        }
        public double getPerimeter() {
            return 2 * (length + width);
        }
        public Object clone() {
            return new Rectangle(getColor(), length, width);
        }

        public void scale(double f) {
            length*=f;
            width*=f;
        }

        public String toString() {
            return "Rectangle\t" + getColor() + "\t" + length + "\t" + width + "\t\t" + 
            getArea() + "\t" + getPerimeter(); 
        }


    }