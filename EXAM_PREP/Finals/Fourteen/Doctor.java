public class Doctor extends Person {
    private String speciality;
    private double visitFee;

    public Doctor() {

    }

    public Doctor(String n, String s, double vf) {
        super(n);
        this.speciality = s;
        this.visitFee = vf;
    }

    public String getSpec() {
        return speciality;
    }

    public double getFee() {
        return visitFee;
    }

    public void setSpec(String id) {
        this.speciality = id;
    }

    public String toString() {
        return "Speciality: " + speciality + "Visit Fee: " + visitFee;
    }


}
