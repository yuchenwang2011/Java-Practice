130. Surrounded Regions
Medium

Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:
X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:
X X X X
X X X X
X X X X
X O X X

Explanation:
Surrounded regions shouldn’t be on the border, 
which means that any 'O' on the border of the board are not flipped to 'X'.
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. 
Two cells are connected if they are adjacent cells connected horizontally or vertically.

Answer:
//先把四条边上的ODFS改成#，然后见到O就变X，同时把#还原成X
class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++){
            //第一列和最后一列
            char a = board[i][0];
            char b = board[i][col - 1];
            if(a == 'O') helper(board, i, 0);
            if(b == 'O') helper(board, i, col - 1);
        }
        
        for(int i = 0; i < col; i++){
            //第一行和最后一行
            char a = board[0][i];
            char b = board[row - 1][i];
            if(a == 'O') helper(board, 0, i);
            if(b == 'O') helper(board, row - 1, i);
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
    
    public void helper(char[][] board, int i, int j){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') return;
        board[i][j] = '#';
        helper(board, i - 1, j);
        helper(board, i + 1, j);
        helper(board, i, j - 1);
        helper(board, i, j + 1);
    }
}
