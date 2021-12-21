package _00_testing;

class Array {
    public static void main(String[] args) {
        int[][] matrix = {{5, 6, -4}, {2, 3, 2}};
        System.out.println(matrixElementsSum(matrix));
    }
    static int matrixElementsSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i - 1][j] != 0) {
                        sum = sum + matrix[i][j];
                    }
                }
            }
        }
        return sum;

    }
}