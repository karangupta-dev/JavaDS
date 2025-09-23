package DataStructures.Arrays.Medium;

public class MatrixZeroes {

    // bad code
//    static void setRightZeros(int row, int col, int[][] board, boolean[][] visited) {
//        col = col + 1;
//        if (col >= board[0].length) {
//            return;
//        }
//        if (board[row][col] != 0){
//            visited[row][col] = true;
//        }
//        board[row][col] = 0;
//        setRightZeros(row, col, board, visited);
//    }
//
//    static void setLeftZeros(int row, int col, int[][] board, boolean[][] visited) {
//        col = col - 1;
//        if (col < 0) {
//            return;
//        }
//        if (board[row][col] != 0){
//            visited[row][col] = true;
//        }
//        board[row][col] = 0;
//        setLeftZeros(row, col, board, visited);
//    }
//
//    static void setBottomZeros(int row, int col, int[][] board, boolean[][] visited) {
//        row = row + 1;
//        if (row >= board.length) {
//            return;
//        }
//        if (board[row][col] != 0){
//            visited[row][col] = true;
//        }
//        board[row][col] = 0;
//        setBottomZeros(row, col, board, visited);
//    }
//
//    static void setTopZeros(int row, int col, int[][] board, boolean[][] visited) {
//        row = row - 1;
//        if (row < 0) {
//            return;
//        }
//        if (board[row][col] != 0){
//            visited[row][col] = true;
//        }
//        board[row][col] = 0;
//        setTopZeros(row, col, board, visited);
//    }
//
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
//
//    public static void main(String[] args) {
//
//        int[][] board = {
//                {1, 2, 0},
//                {4, 1, 6},
//                {0, 8, 4}
//        };
//        boolean visited[][] = new boolean[3][3];
//
//        System.out.println("\n Original:");
//        printMatrix(board);
//
//        for (int r = 0; r < 3; r++) {
//            for (int c = 0; c < 3; c++) {
//                if (board[r][c] == 0 && !visited[r][c]) {
//                    setTopZeros(r, c, board, visited);
//                    setBottomZeros(r, c, board, visited);
//                    setLeftZeros(r, c, board, visited);
//                    setRightZeros(r, c, board, visited);
//                }
//            }
//        }
//
//        System.out.println("\n Updated:");
//        printMatrix(board);
//    }

    public static void main(String[] args) {
        //optimized solution

        int[][] matrix = {
                {1, 2, 0},
                {4, 1, 6},
                {0, 8, 4}
        };

        System.out.println("\n Original:");
        printMatrix(matrix);

        int m = matrix.length, n = matrix[0].length;
        boolean[] zeroRows = new boolean[m];
        boolean[] zeroCols = new boolean[n];

        // Find all zeros and mark rows/columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        // Set zeros based on markers
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (zeroRows[i] || zeroCols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

        System.out.println("\n Updated:");
        printMatrix(matrix);

    }
}
