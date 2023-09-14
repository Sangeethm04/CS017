public class Employee extends Person {
    private String position;
    private double salary;

    public Employee() {
        super();
        position = "none";
        salary = 0.0;


    }

    public Employee(int id, String name, String address, String phone, String email, String position, double salary) {
        super(id, name, address, phone, email);
        this.position = position;
        this.salary = salary;
}

public String getPosition() {
    return position;
}
public double getSalary() {
    return salary;
}

public void setPosition(String p) {
    position = p;
}
public void setSalary(double s) {
    salary = s;
}

public String toString() {
    String out = super.toString();
    out += String.format("Position: %s\nAnnual Salary: $%.2f\n",position, salary);
    return out;
}
}