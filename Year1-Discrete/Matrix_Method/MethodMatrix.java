package Matrix_Method;

public class MethodMatrix {
    public void displayMatrix(int[][] arrMat) {
        System.out.print("   ");
        for (int i = 1; i <= arrMat.length; i++) {
            System.out.printf("\tv%d", i);
        }
        System.out.println();
        for (int i = 0; i < arrMat.length; i++) {
            System.out.printf("v%d", i + 1);
            for (int j = 0; j < arrMat[0].length; j++) {
                System.out.printf("\t%d ", arrMat[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] multiplyMatrix(int[][] a, int[][] b) {
        int[][] result = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < a[0].length; k++) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    public void identityMatrix(int[][] arr, int[][] r, int p) {
        System.out.printf("%nDisplay the Matrix power to the power of %d:%n", p);
        if (p == 0) {
            r = new int[][] {
                    { 1, 0, 0, 0, 0 },
                    { 0, 1, 0, 0, 0 },
                    { 0, 0, 1, 0, 0 },
                    { 0, 0, 0, 1, 0 },
                    { 0, 0, 0, 0, 1 } };
            displayMatrix(r);
        } else {
            r = arr;
            for (int i = 1; i < p; i++) {
                r = multiplyMatrix(r, arr);
            }
            displayMatrix(r);
        }
    }
}