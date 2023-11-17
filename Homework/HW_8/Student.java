/**
 * class student that implements comparable
 */
public class Student implements Comparable < Student > {
    private int id;
    private String name;
    private double gpa;

    /**
     * default constructor
     */
    public Student() {

    }

    /**
     * constructor with parameters
     * @param id
     * @param name
     * @param gpa
     */
    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    /**
     * getter for id
     * @return int id
     */
    public int getID() {
        return id;
    }

    /**
     * getter for name
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * getter for gpa
     * @return double gpa
     */
    public double getGPA() {
        return gpa;
    }

    /**
     * setter for id
     * @param id
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * setter for name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter for gpa
     * @param gpa
     */
    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    /**
     * tostring method
     * @return String of attributes
     */
    public String toString() {
        return id + " " + name + " " + gpa;
    }

    /**
     * compareto method of comparable implemented
     * @param a
     * @return int
     */
    public int compareTo(Student a) {
        if (this.getID() < a.getID()) {
            return -1;
        } else if (this.getID() > a.getID()) {
            return 1;
        } else {
            return 0;
        }
    }

}