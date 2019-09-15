52. N-Queens II
Hard

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return the number of distinct solutions to the n-queens puzzle.
Example:
Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

Answer:
// 00 01 02 03 04
// 10 11 12 13 14
// 20 21 22 23 24
// 30 31 32 33 34
// 40 41 42 43 44
//you can tell, the substract on \ direction always same
//the sum on / direction always same
//看到有人说，感觉有些道理：时间 O(N^2) 空间 O(N)
class Solution {
    int result = 0;
    public int totalNQueens(int n){
        if(n <= 0) return result;
        boolean[] colsPlaced = new boolean[n];
        //for case board[0][3] 0 - 3 = -3, board[3][0] 3 - 0 = 3
        //size is [-3,3], so we need size 2 * n
        boolean[] dig1Placed = new boolean[n * 2];
        //size is [0,6]
        boolean[] dig2Placed = new boolean[n * 2];
        helper(0, colsPlaced, dig1Placed, dig2Placed, n);
        return result;
    }

    public void helper(int row, boolean[] colsPlaced, boolean[] dig1Placed, boolean[] dig2Placed, int n){
        if(row == n) {
            result++;
            return;
        }
        for(int col = 0; col < n; col++){
            int dig1 = row - col + n;
            int dig2 = row + col;
            if(colsPlaced[col] || dig1Placed[dig1] || dig2Placed[dig2]) continue;
            colsPlaced[col] = true;
            dig1Placed[dig1] = true;
            dig2Placed[dig2] = true;
            helper(row + 1, colsPlaced, dig1Placed, dig2Placed, n);
            colsPlaced[col] = false;
            dig1Placed[dig1] = false;
            dig2Placed[dig2] = false;
         }
    }
}


//也可以用上一题的方法去做
class Solution {
    int result = 0;
    public int totalNQueens(int n) {
        if(n <= 0) return result;
        
        int[] queen = new int[n];
        helper(queen, n, 0);
        return result;
    }
    
    public void helper(int[] queen, int n, int row){
        if(row >= queen.length) {
            result++;
            return;
        }
        for(int col = 0; col < queen.length; col++){
            queen[row] = col;
            if(isValid(queen, row)) {
                helper(queen, n, row + 1);
            }
        }
    }
    
    public boolean isValid(int[] queen, int row){
        for(int i = 0; i < row; i++){
            if(queen[row] == queen[i]) return false;
            if(Math.abs(queen[row] - queen[i]) == Math.abs(row - i)) return false;
        }
        return true;
    }
}
