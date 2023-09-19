import java.util.Scanner;

public class Recursion {
    public static int count(String str, char c) {
      if(str.length() == 0) {
        return 0;
      } else {
        if(str.charAt(0) == c) {
            return 1 + count(str.substring(1), c); //recursive call
        }
        else {
            return count(str.substring(1), c); // recursive
        }
      }
    }

    public static void permutations(String s) {
      permutations(" ",s);
    }
     public static void permutations(String s1, String s2) {
      if(s2.length() == 0) {//base case
        System.out.println(s1);
      } else {
        for(int i =0; i<s2.length(); i++) {
          permutations(s1 + s2.charAt(i),s2.substring(0,i)+ s2.substring(i+1));//recursive case
        }
      }
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = keyboard.nextLine();
        System.out.println("Enter a character: ");
        char c = keyboard.nextLine().charAt(0);
        System.out.println(c + " appears " + count(str, c) + " times in \"" + str + "\"");
        System.out.println("Enter a string: ");
        str = keyboard.nextLine();
        permutations(str);
    }
}