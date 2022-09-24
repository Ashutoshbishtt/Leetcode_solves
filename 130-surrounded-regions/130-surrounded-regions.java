class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if((i == 0 || j == 0 || i == n-1 || j == m - 1) && board[i][j] == 'O'){
                    dfs(board, i, j);
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'a'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board, int i, int j){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == 'a'){
            return;
        }
        if(board[i][j] == 'O') {
            board[i][j] = 'a';
        }
        dfs(board, i + 1 , j);        
        dfs(board, i - 1 , j);
        dfs(board, i  , j + 1);
        dfs(board, i , j - 1);

    }
}