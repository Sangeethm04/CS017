// Class Patient
public class Patient extends Person{
	private Doctor primaryPhysician;
     public Patient() {
    	super();
    	primaryPhysician = null;
     }
     public Patient(String n, Doctor d) {
    	super(n);
    	primaryPhysician = d;
     }
     public Doctor getPP() {
    	return primaryPhysician;
     }
     public void setPP(Doctor d) {
    	primaryPhysician = d;
     }
     public String toString() {
    	return super.toString() + " " +
           	primaryPhysician.getName();
     }
}