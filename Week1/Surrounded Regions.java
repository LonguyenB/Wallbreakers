class Solution {
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        
        for (int i = 0; i < board.length; i++) {
            DFS(board, i, 0);
            DFS(board, i, board[i].length-1);
        }
        for (int j = 0; j < board[0].length; j++) {
            DFS(board, 0, j);
            DFS(board, board.length-1, j);
        }

        
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'N') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    public static void DFS(char[][] board, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[i].length) {
            if (board[i][j] == 'O') {
                board[i][j] = 'N';
                DFS(board, i + 1, j);
                DFS(board, i - 1, j);
                DFS(board, i, j + 1);
                DFS(board, i, j - 1);
            }
        }
    }
}