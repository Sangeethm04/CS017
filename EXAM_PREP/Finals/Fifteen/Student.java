public class Student implements Comparable<Student>{
    private String name;
    private double GPA;

    public Student() {
        name="";
        GPA=0.0;
    }

    public Student(String name, double GPA) {
        this.name = name;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return GPA;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int compareTo(Student s) {
        return this.name.compareTo(s.getName());
    }

    public String toString() {
        return "Name: " + name + " GPA: " + GPA; 
    }

}
