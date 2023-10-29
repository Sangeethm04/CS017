public class Country implements Comparable<Country>{
	private String code, name;
	private double area;
	
	public Country(String c, String n, double a) {
		code = c;
		name = n;
		area = a;
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public double getArea() {
		return area;
	}
	
	public void setCode(String c) {
		code = c;
	}
	public void setName(String n) {
		name = n;
	}
	public void setArea(double a) {
		area = a;
	}
	public String toString() {
		return "("+ code + ", " + name + ", "+ area + "sq.ft)";
	}
	public boolean equals(Object o) {
		if(o instanceof Country) {
			Country c = (Country) o;
			return name.equals(c.name);
		}
		return false;
	}
	public int compareTo(Country c) {
		return code.compareTo(c.code);
	}
}
