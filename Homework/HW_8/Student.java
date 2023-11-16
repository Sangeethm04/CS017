public class Student implements Comparable < Student > {
    private int id;
    private String name;
    private double gpa;

    public Student() {

    }

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return gpa;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    public String toString() {
        return id + name + gpa;
    }

    public int compareTo(Student a) {
        if (this.getGPA() < a.getGPA()) {
            return -1;
        } else if (this.getGPA() > a.getGPA()) {
            return 1;
        } else {
            return 0;
        }
    }

}