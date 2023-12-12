public class Billing {
	private Patient patient;
	private Doctor doctor;
	public Billing() {
   	patient = null; doctor = null;
	}
	public Billing(Patient p, Doctor d) {
   	patient = p; doctor = d;
	}
	public Patient getPatient() { return patient; }
	public Doctor getDoctor() { return doctor; }
	public void setPatient(Patient p) { patient = p;}
	public void setDoctor(Doctor d) { doctor=d; }
	public String toString() {
   	return "Patient: " + patient.toString() +
                 	", Doctor: " + doctor.toString();
	}
}
