package DataStructures.Arrays.Medium;

public class WordSearch {

    public static boolean dfs(char[][] board, int r, int c, String word, boolean[][] visited) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c]) {
            return false;
        }

        if (board[r][c] == word.charAt(0)) {
            visited[r][c] = true;
            word = word.substring(1);
            if (word.isEmpty()) {
                return true;
            }
            boolean left = dfs(board, r, c - 1, word, visited);
            boolean right = dfs(board, r, c + 1, word, visited);
            boolean top = dfs(board, r - 1, c, word, visited);
            boolean bottom = dfs(board, r + 1, c, word, visited);
            visited[r][c] = false;

            return left || right || top || bottom;
        } else {
            return false;
        }
    }

    public static boolean exist(char[][] board, String word) {

        int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean res = dfs(board, i, j, word, visited);
                    if (res == true) {
                        return res;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'T', 'Q'}
        };
        String word = "BCETD";
        boolean isExist = WordSearch.exist(board, word);
        System.out.println("Word Exist: " + isExist);
    }

}
