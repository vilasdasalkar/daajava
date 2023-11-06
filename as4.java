import java.util.Scanner;

public class as4 {
    public static int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] K = new int[n + 1][W + 1];

        // Build table K[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                } else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }

        return K[n][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int numItems = scanner.nextInt();

        int[] val = new int[numItems];
        int[] wt = new int[numItems];

        System.out.println("Enter the values of the items in order:");
        for (int i = 0; i < numItems; i++) {
            val[i] = scanner.nextInt();
        }

        System.out.println("Enter the positive weights of the items in order:");
        for (int i = 0; i < numItems; i++) {
            wt[i] = scanner.nextInt();
        }

        System.out.print("Enter the maximum weight (W): ");
        int W = scanner.nextInt();

        int maxVal = knapSack(W, wt, val, numItems);
        System.out.println("Maximum value that can be obtained: " + maxVal);
    }
}
