package LeetCode;

public class Question4 {
    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3}, {4,5,6},{7,8,9}};
        rotate(matrix1);
        int[][] matrix2 = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        rotate(matrix2);

    }
    // assume there are n elements in matrix
    // TC = O(n)
    // SC = O(1)
    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        return matrix;
    }

}
