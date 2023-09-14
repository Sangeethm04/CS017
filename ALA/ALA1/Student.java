public class Student extends Person {
    public String major;

    public Student() {
        super();
    }

    public Student(int id, String name, String address, String phone, String email, String major) {
        super(id, name, address, phone, email);
        this.major = major;
    }

    public String getMajor(){return major;}
    public void setMajor(String m){major = m;}

    /**
     * @Override
     */
    public String toString() {
        return super.toString() + "Major: " + major + "\n";
        
    }
}