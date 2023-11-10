public class Patient implements Comparable < Patient > {
    private String name;
    private int age,
    type;
    public Patient(String n, int a, int t) {
        name = n;
        age = a;
        type = t;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getType() {
        return type;
    }
    public void setName(String n) {
        name = n;
    }
    public void setAge(int a) {
        age = a;
    }
    public void setType(int t) {
        type = t;
    }
    public String toString() {
        return String.format("(%-20s %d %d)", name, age, type);
    }
    public boolean equals(Object o) {
        if (o instanceof Patient) {
            Patient p = (Patient) o;
            return this.name.equals(p.name);
        }
        return false;
    }
    public int compareTo(Patient p) {
        return this.type - p.type;
    }


}