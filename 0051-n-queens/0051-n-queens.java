class Solution {

    public static void nqueen(char[][] board, int row,
                              List<List<String>> ans) {

        // All rows have a queen: save the solution
        if (row == board.length) {
            List<String> temp = new ArrayList<>();

            for (int i = 0; i < board.length; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (issafe(board, row, j)) {
                board[row][j] = 'Q';

                nqueen(board, row + 1, ans);

                // Backtracking
                board[row][j] = '.';
            }
        }
    }

    public static boolean issafe(char[][] board, int row, int col) {

        // Check vertically upward
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check diagonal left
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check diagonal right
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        List<List<String>> ans = new ArrayList<>();
        nqueen(board, 0, ans);
        return ans;
    }
}