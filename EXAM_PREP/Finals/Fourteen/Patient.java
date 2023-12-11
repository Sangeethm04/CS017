public class Patient extends Person {
    private Doctor primaryPhysician;

    public Patient() {

    }

    public Patient(String n, String pp) {
        super(n);
        this.primaryPhysician.setName(pp);
    }

    public String getPP() {
        return primaryPhysician.getName();
    }

    public void setPP(String pp) {
        this.primaryPhysician.setName(pp);
    }

    public String toString() {
        return primaryPhysician.toString();
    }
}
