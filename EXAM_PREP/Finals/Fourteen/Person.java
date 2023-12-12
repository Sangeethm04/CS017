// Class Person
public abstract class Person {
   private String name;
   protected Person() { name =""; }
   protected Person(String name) { this.name = name; }
   public String getName() { return name; }
   public void setName(String n) { name = n; }
   public String toString() { return name; }
   public boolean equals(Object o) {
  	if(o instanceof Person){
     	Person p = (Person) o;
     	return p.name.equals(name);
  	}
  	return false;
   }
}