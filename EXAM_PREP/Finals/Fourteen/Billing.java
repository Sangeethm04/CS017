public class Billing {
    private Patient patient;
    private Doctor doctor;

    public Billing(){

    }

    public Billing(Patient p, Doctor d) {
        this.patient = p;
        this.doctor = d;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setPatient(Patient p) {
        this.patient = p;
    }

    public void setDoctor(Doctor d) {
        this.doctor = d;
    }

    public String toString() {
        return patient.toString() + doctor.toString();
    }
}
