public class GCD {
    public static int iter1, iter2, iter3, iter4;
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

    public static int gcd_3(int m, int n) {
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

    public static int gcd_4(int m, int n) {
        iter4++;
        if (m % n == 0)
            return n;
        else
            return gcd_4(n, m % n);
    }

    public static void main(String[] args) {
        
        System.out.println("Comparison of the execution times");
        System.out.println("Number1\tNumber2\tTime_1\tTime_2\tTime_3\tTime_4");
        int random1 = 0;
        int random2 = 0;
        for (int i = 0; i < 20; i++) {
             random1 = (int)(Math.random() * 1000000);
             random2 = (int)(Math.random() * 1000000);
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
        System.out.println("Number1\tNumber2\tTime_1\tTime_2\tTime_3\tTime_4");
        System.out.printf("%-10d %-10d %-10d %-10d %-10d %-10d\n", random1, random2, iter1, iter2, iter3, iter4);
    }
}