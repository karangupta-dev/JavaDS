package DataStructures.Arrays.Medium;

public class Rotate_N_Dimension_Matrix {

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reverseRows(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int left = 0;
            int right = matrix.length - 1;

            while (left < right) {
                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;

                left++;
                right--;
            }
        }
    }

    private void reverseColumns(int[][] matrix) {
        for (int column = 0; column < matrix[0].length; column++) {
            int top = 0;
            int bottom = matrix.length - 1;

            while (top < bottom) {
                int temp = matrix[top][column];
                matrix[top][column] = matrix[bottom][column];
                matrix[bottom][column] = temp;

                top++;
                bottom--;
            }
        }
    }

    public void rotate90DegRight(int[][] matrix) {
        transpose(matrix);
        reverseRows(matrix);
    }

    public void rotate90DegLeft(int[][] matrix) {
        transpose(matrix);
        reverseColumns(matrix);
    }

    public static void main(String[] args) {
        Rotate_N_Dimension_Matrix obj = new Rotate_N_Dimension_Matrix();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Original Matrix:");
        printMatrix(matrix);

        obj.rotate90DegRight(matrix);
        System.out.println("\nMatrix after 90 degree right rotation:");
        printMatrix(matrix);

        obj.rotate90DegLeft(matrix);
        obj.rotate90DegLeft(matrix);
        System.out.println("\nMatrix after 90 degree left rotation:");
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
