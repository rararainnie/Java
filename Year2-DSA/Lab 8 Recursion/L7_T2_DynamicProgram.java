public class L7_T2_DynamicProgram {
    public static void main(String[] args) {
        int[][] data = {
                { 0, 1, 1, 0, 1 },
                { 1, 1, 0, 1, 0 },
                { 0, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0 }
        };

        L7_T2_DynamicProgram maxSquareSubMatrix = new L7_T2_DynamicProgram();
        maxSquareSubMatrix.q1_2_maximum_size_square_sub_matrix(data);
    }

    public void q1_2_maximum_size_square_sub_matrix(int[][] data) {
        int rows = data.length;
        int cols = data[0].length;

        int[][] sub = new int[rows + 1][cols + 1];

        // Initialize base case (zeros in the new row 0 and col 0)
        for (int i = 0; i <= rows; i++) {
            sub[i][0] = 0;
        }
        for (int j = 0; j <= cols; j++) {
            sub[0][j] = 0;
        }

        int maxSize = 0; // To keep track of the longest length

        // Calculate the sub-matrix
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (data[i - 1][j - 1] == 1) {
                    sub[i][j] = Math.min(sub[i - 1][j], Math.min(sub[i][j - 1], sub[i - 1][j - 1])) + 1;
                    maxSize = Math.max(maxSize, sub[i][j]); // Update maxSize
                } else {
                    sub[i][j] = 0;
                }
            }
        }

        // Output the result
        System.out.println("Maximum size square sub-matrix with all 1s: " + maxSize);
    }

}
