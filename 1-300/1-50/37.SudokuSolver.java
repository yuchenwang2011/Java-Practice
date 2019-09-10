Write a program to solve a Sudoku puzzle by filling the empty cells.
A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.


Answer:
//https://www.youtube.com/watch?v=qKk--WUQKMQ
//time complexity: 9 ^ m (m represents the number of blanks to be filled in),
//since each blank can have 9 choices
class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        if(board.length > 9 || board[0].length > 9) return;
        
        solveHelper(board);
    }
    

    public boolean solveHelper(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.') continue;
                
                for(char c = '1'; c <= '9'; c++){
                    if(isValid(board, i, j, c)){
                        board[i][j] = c;
                        if(solveHelper(board)){
                            //no need finish all 9 numbers
                            return true;
                        } else {
                            board[i][j] = '.';
                        }
                    }
                }
                //if have finished all 9 numbers but still have not returned once
                return false;
            }
        }
        return true;
    }
    

    public boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < board.length; i++){
            //it means the number has existed, the new filled number is not valid
            if(board[row][i] != '.' && board[row][i] == c) return false;
            if(board[i][col] != '.' && board[i][col] == c) return false;
            
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if(board[boxRow][boxCol] != '.' && board[boxRow][boxCol] == c) return false;
        }
        return true;
    }
}
