/*65050389 Thumasorn Prasertsri */

import java.util.Arrays;

public class Lab7_max_square_and_edit_distance {
    // Task 1 Question 1
    public static class L7_T1_MaxSquare {
        private static int[][] matrix;
        private static int rows;
        private static int cols;
        private static int max_so_far_for_recursion = -1;

        public static int find_max_area_recurse_entry(int[][] mat) {
            // begin preparation
            matrix = mat;
            rows = matrix.length;
            cols = matrix[0].length;
            // end preparation
            q1_1_find_max_area_recurse(matrix, 0, 0);
            return max_so_far_for_recursion * max_so_far_for_recursion;
        }

        private static int q1_1_find_max_area_recurse(int[][] mat, int r, int c) {
            if (r == rows || c == cols)
                return 0;
            int right = q1_1_find_max_area_recurse(mat, r, c + 1);
            int down = q1_1_find_max_area_recurse(mat, r + 1, c);
            int diagonal = q1_1_find_max_area_recurse(mat, r + 1, c + 1);

            int size = 0;
            if (mat[r][c] == 1) {
                size = Math.min(Math.min(right, down), diagonal) + 1;
            }

            max_so_far_for_recursion = size > max_so_far_for_recursion ? size : max_so_far_for_recursion;
            return size;
        }
    }

    // Task 1 Question 2
    public static void q1_2_maximum_size_square_sub_matrix(int[][] data) {
        int rows = data.length;
        int cols = data[0].length;

        int[][] sub = new int[rows + 1][cols + 1];
        int maxSize = 0;

        // Calculate the sub-matrix
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (data[i - 1][j - 1] == 1) {
                    sub[i][j] = Math.min(sub[i - 1][j], Math.min(sub[i][j - 1], sub[i - 1][j - 1])) + 1;
                    maxSize = Math.max(maxSize, sub[i][j]); // Update maxSize
                }
            }
        }

        System.out.println("Maximum size square sub-matrix with all 1s: " + maxSize);
    }

    // Task 2
    private static int q2_string_edit_distance(String str1, String str2) {
        // Begin preparation
        int[][] cache = new int[str1.length() + 1][str2.length() + 1];
        for (int[] row : cache) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int r;
        for (r = 0; r < cache.length; r++) {
            cache[r][str2.length()] = str2.length() - r;
        }
        for (int c = 0; c < cache[0].length; c++) {
            cache[str1.length()][c] = str1.length() - c;
        }
        // End preparation

        // Compute the edit distance using dynamic programming
        for (int i = str1.length() - 1; i >= 0; i--) {
            for (int j = str2.length() - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    cache[i][j] = cache[i + 1][j + 1];
                } else {
                    int insert = cache[i][j + 1] + 1;
                    int delete = cache[i + 1][j] + 1;
                    int replace = cache[i + 1][j + 1] + 1;
                    cache[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return cache[0][0];
    }
}