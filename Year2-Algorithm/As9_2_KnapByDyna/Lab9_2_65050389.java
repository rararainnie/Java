import java.util.Arrays;

public class Lab9_2_65050389 {
    public static void main(String[] args) {
        int[] profits = { 20, 8, 21, 13, 1, 19, 15 };
        int[] weights = { 4, 10, 6, 9, 8, 9, 8 };
        int capacity = 19;

        int n = profits.length;

        int[][] dp = new int[n + 1][capacity + 1];

        for (int j = 1; j <= n; j++) {
            for (int d = 0; d <= capacity; d++) {
                if (d < weights[j - 1]) {
                    dp[j][d] = dp[j - 1][d];
                } else {
                    dp[j][d] = Math.max(dp[j - 1][d], dp[j - 1][d - weights[j - 1]] + profits[j - 1]);
                }
            }
        }

        System.out.println("n = " + n + ", C = " + capacity);
        System.out.println("P: " + Arrays.toString(profits).replace("[", "").replace("]", ""));
        System.out.println("W: " + Arrays.toString(weights).replace("[", "").replace("]", "") + "\n");

        System.out.print("     ");
        for (int count = 0; count <= capacity; count++) {
            System.out.printf("%-4d", count);
        }

        System.out.println();
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.print("     ");
            } else {
                System.out.printf("%-5d", i - 1);
            }
            for (int j = 0; j <= capacity; j++) {
                System.out.printf("%-4d", dp[i][j]);
            }
            System.out.println();
        }

    }
}
