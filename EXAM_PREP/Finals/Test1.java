public class Test1 {
    public static void main(String[] args) {
        computeSeries();
    }
    //     Write a recursive method to compute the following series:
    //     M(n) = 1 + 1/3+ 2/5+ . . . +n/2n+1

    // Write a test program that displays M(n) for n = 1, 2, . . ., 10
    public static void computeSeries() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("M(" + i + ") = " + computeSeries(i));
        }

    }

    public static double computeSeries(double n) {
        if (n == 1) {
            return 1;
        } else {
            return n / (2 * n + 1) + computeSeries(--n);
        }

    }


}