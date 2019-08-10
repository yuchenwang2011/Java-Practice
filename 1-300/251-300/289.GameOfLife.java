289. Game of Life My Submissions Question
Total Accepted: 11919 Total Submissions: 35824 Difficulty: Medium
According to the Wikipedia's article: "The Game of Life, 
also known simply as Life, is a cellular automaton devised 
by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) 
using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: 
You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. 
In principle, the board is infinite, 
which would cause problems when the active area encroaches the border of the array. 
How would you address these problems?

Answer:
//由于细胞只有两种状态0和1，因此可以使用二进制来表示细胞的生存状态
//更新细胞状态时，将细胞的下一个状态用高位进行存储
//全部更新完毕后，将细胞的状态右移一位
//怎么想出来的：
// 1. If I want to reuse the existing space, I'd need to store both the old and new states in each cell.
// 2. There are 4 combinations of old and new values: 00, 01, 10, 11.
// 3. I can either use the first or second bit for the old value.
// 4. I tried both. Both work. Using the first bit for the old value, however, use 1 fewer loop.
public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length ==0) return;
        int row = board.length, column = board[0].length;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                int live = countLife(board,i,j);
                //at beginning, all the second bits are 0
                //so we only need to take care of when 0 --> 1 for second bit
                //There are 4 cases:
                //from dead to dead, from live to dead, from live to live, from dead to live
                //so only the third one, from dead to live
                if(live == 3 && board[i][j] ==0){
                    board[i][j] = 2; //it was 00 before, now make the second bit to 1, to be 10
                }
                //for dead to dead/live to dead we don't need to do anything.
                //so for live to live, it was 01 before, so change second bit, now it's 11
                if(board[i][j]==1 && (live >=2 && live <=3)){
                    board[i][j] = 3;
                }
            }
        }
        for(int i =0; i < row; i++){
            for(int j = 0; j < column; j++){
                board[i][j] >>= 1;
            }
        }
    }
    
    public int countLife(int[][] board,int i, int j){
        int live = 0;
        for(int x = Math.max(i-1,0); x <= Math.min(i+1,board.length-1); x++){
            for(int y = Math.max(0,j-1); y <= Math.min(j+1, board[0].length-1); y++){
                live = live + (board[x][y] & 1);
            }
        }
        if(board[i][j] == 1) live--;
        return live;
    }
}
