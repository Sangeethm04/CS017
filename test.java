
public class test {
// Returns 0 if value is not prime, 1 if value is prime
   public static void infinite(int testVal) {
    if(testVal == 10000000) {
        System.out.println("hello"); 
    } else {
        System.out.println(testVal); 
    infinite(testVal+1);
   }
}
   public static void main(String[] args) {
          // Value checked for prime

      // Check primes for values 1 to 10
      infinite(1);
   }

}
