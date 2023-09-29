/**
 * This program compares the execution times and the number of iterations of four methods
 */
public class GCD {
    public static int iter1, iter2, iter3, iter4;
    /**
     * This method returns the greatest common divisor of two integers
     * time complexity: O(n)
     * @param m
     * @param n
     * @return
     */
    public static int gcd_1(int m, int n) {
        iter1 = 0;
        int divisor = 1;
        for (int i = 2; i < m && i < n; i++) { // n-2 iterations
            iter1++;
            if (m % i == 0 && n % i == 0)
                divisor = i;
        }
        return divisor;
    }

    /**
     * This method returns the greatest common divisor of two integers
     * time complexity: O(n)
     * @param m
     * @param n
     * @return
     */
    public static int gcd_2(int m, int n) {
        int divisor = 1;
        iter2 = 0;
        for (int i = n; i >= 1; i--) { // n iterations
            iter2++;
            if (m % i == 0 && n % i == 0) {
                divisor = i;
                break;
            }
        }
        return divisor;
    }

    /**
     * This method returns the greatest common divisor of two integers
     * time complexity: O(n)
     * @param m
     * @param n
     * @return
     */
    public static int gcd_3(int m, int n) {
        iter3 = 0;
        int divisor = 1;
        if (m % n == 0)
            return n;
        for (int i = n / 2; i >= 1; i--) { // n/2 iterations
            iter3++;
            if (m % i == 0 && n % i == 0) {
                divisor = i;
                break;
            }
        }
        return divisor;
    }

    /**
     * This method returns the greatest common divisor of two integers
     * time complexity: O(logn)
     * @param m
     * @param n
     * @return
     */
    public static int gcd_4(int m, int n) {
        iter4++;
        if (m % n == 0)
            return n;
        else
            return gcd_4(n, m % n);
    }

    /**
     * Compares the execution times of the four methods
     */
    public static void compareExecutionTimes() {

        System.out.println("Comparison of the execution times");
        System.out.println("Number1    Number2    Time_1     Time_2     Time_3     Time_4");

        for (int i = 0; i < 20; i++) {
            int random1 = (int)(Math.random() * 1000000);
            int random2 = (int)(Math.random() * 1000000);
            long start = System.nanoTime(); // return the current time in ns
            gcd_1(random1, random2);
            long end = System.nanoTime();
            long exec1 = (end - start);

            start = System.nanoTime();
            gcd_2(random1, random2);
            end = System.nanoTime();
            long exec2 = (end - start);

            start = System.nanoTime();
            gcd_3(random1, random2);
            end = System.nanoTime();
            long exec3 = (end - start);

            iter4 = 0;
            start = System.nanoTime();
            gcd_4(random1, random2);
            end = System.nanoTime();
            long exec4 = (end - start);

            System.out.printf("%-10d %-10d %-10d %-10d %-10d %-10d\n", random1, random2, exec1, exec2, exec3, exec4);
        }

    }

    /**
     * Compares the number of iterations of the four methods
     */
    public static void compareIterations() {
        System.out.println("Comparison of the number of iterations");
        System.out.println("Number1  Number2  Iterations_1 Iterations_2 Iterations_3 Iterations_4");


        for (int i = 0; i < 20; i++) {
            int random1 = (int)(Math.random() * 1000000);
            int random2 = (int)(Math.random() * 1000000);

            gcd_1(random1, random2);
            gcd_2(random1, random2);
            gcd_3(random1, random2);
            iter4 = 0;
            gcd_4(random1, random2);

            System.out.printf("%-10d %-10d %-10d %-10d %-10d %-10d\n", random1, random2, iter1, iter2, iter3, iter4);

        }
    }
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        compareExecutionTimes();
        compareIterations();
    }
}
/*
 * The results are clear that the logn algorithm is the most efficient one. We can see this in the runtimes and the number of iterations. The rest are all O(n) algorithms and therefore relatively similar in speed and number of iterations. The iterations and speed generally correlate with each other. The more iterations, the longer the runtime. Therefore it is clear that using euclid's algorithm is the most efficient way to find the greatest common divisor. This can be applied to say that using a splitting method is generally faster than a linear method. 
 */