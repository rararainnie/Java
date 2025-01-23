package Matrix_Method;

public class DisplayMatrix {
    public void showDisplay(int[][] matrix) {
        System.out.print("   ");
        for (int i = 1; i <= matrix.length; i++) {
            System.out.printf("\tv%d", i);
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("v%d", i + 1);
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("\t%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
