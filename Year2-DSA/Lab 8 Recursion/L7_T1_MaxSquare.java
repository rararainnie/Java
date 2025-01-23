class L7_T1_MaxSquare {
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