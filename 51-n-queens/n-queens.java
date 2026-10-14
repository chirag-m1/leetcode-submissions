class Solution {
    boolean isSafe(int row, int col, int n, String[][] board) {
        for(int i = 0; i < row; i++) {
            if(board[i][col].equals("Q")) {
                return false;
            }
        }

        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j].equals("Q")) {
                return false;
            }
        }

        for(int i = row-1, j = col+1; i >= 0 && j < n; i--, j++) {
            if(board[i][j].equals("Q")) {
                return false;
            }
        }
        return true;
    }
    void nQueen(int row, int n, String[][] board, List<List<String>> boards) {
        if(row == n) {
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
                temp.add(sb.toString());
            }
            boards.add(temp);
        }
        for(int col = 0; col < n; col++) {
                if(isSafe(row, col, n, board)) {
                board[row][col] = "Q";
                nQueen(row+1, n, board, boards);
                board[row][col] = ".";
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> boards = new ArrayList<>();
        String[][] board = new String[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], ".");
        }
        nQueen(0, n, board, boards);
        return boards;
    }
}