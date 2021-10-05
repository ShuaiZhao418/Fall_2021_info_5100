package LeetCode;

public class Question1 {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        transpose(matrix1);
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}};
        transpose(matrix2);
    }

    // TC = O(row * col)
    // SC = O(1) (result is output, it does not count)
    public static int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] result = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
