// Class Doctor
public class Doctor extends Person{
   private String specialty;
   private double visitFee;
   public Doctor() {
 	super();
 	specialty=""; visitFee = 0.0;
   }
   public Doctor(String n, String s, double f) {
 	super(n);
 	specialty = s; visitFee = f;
   }
   public String getSpec() { return specialty;}
   public double getFee() { return visitFee;}
   public void setSpec(String s)  {specialty = s;}
   public void setFee(double f) { visitFee = f;}
   public String toString() {
  	return super.toString() + " " + specialty + " " +
                                          	visitFee;
   }
}