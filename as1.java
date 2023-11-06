import java.util.Scanner;

public class as1 {
    public static int recurFibo(int n) {
        if (n <= 1) {
            return n;
        } else {
            return recurFibo(n - 1) + recurFibo(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many terms? ");
        int nTerms = scanner.nextInt();

        if (nTerms <= 0) {
            System.out.println("Please enter a positive integer");
        } else {
            System.out.println("Fibonacci sequence:");
            for (int i = 0; i < nTerms; i++) {
                System.out.println(recurFibo(i));
            }
        }
    }
}
