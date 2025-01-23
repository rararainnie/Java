public class Lab7_65050389 {
    static int n = 4;
    static int[] weights = { 11, 13, 8, 9 };
    static int M = weights[1] + weights[2] + weights[3];
    static boolean[] solution = new boolean[n];

    static void subsetSum(int currentIndex, int currentSum) {
        if (currentIndex == n || currentSum > M) {
            return;
        }

        for (int i = currentIndex; i < n; i++) {
            solution[i] = true;
            subsetSum(i + 1, currentSum + weights[i]);
            solution[i] = false;
        }
    }

    static void printSolution() {
        System.out.print("\nOutput => (w0,w1,w2,w3) = (");

        for (int i = 0; i < n; i++) {
            System.out.print(weights[i]);
            if (i < n - 1) {
                System.out.print(",");
            }
        }
        System.out.println(") M=" + M);
        System.out.println("\nix\t x\tx0,x1,x2,x3");

        for (int i = 0; i < (1 << n); i++) {
            int sum = 0;
            System.out.printf("%2d\t%s\t    ", i, String.format("%4s", Integer.toBinaryString(i)).replace(' ', '0'));

            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    System.out.print("1");
                    sum += weights[j];
                } else {
                    System.out.print("0");
                }
            }

            System.out.print("\tS=" + sum);
            if (sum == M) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        subsetSum(0, 0);
        printSolution();
    }
}
