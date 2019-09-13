51. N-Queens
Hard
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, 
 where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:
Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.

Answer:
class Solution {
    //https://www.youtube.com/watch?v=6GnaTKD_Y0I
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(n <= 0) return result;
        
        int[] queens = new int[n];
        helper(result, queens, 0);
        return result;
    }
    
    public void helper(List<List<String>> result, int[] queens, int pos){
        if(pos >= queens.length) {
            addSolution(result, queens);
            return;
        }
        for(int i = 0; i < queens.length; i++){
            queens[pos] = i;
            if(isValid(queens, pos)){
                helper(result, queens, pos + 1);
            }
            //this seems not necessary
            // queens[pos] = 0;
        }
    }
    
    public boolean isValid(int[] queens, int pos){
        for(int i = 0; i < pos; i++){
            if(queens[pos] == queens[i]) return false;
            //可以这么理解 列数的差距和行数的差距是一样的时候 就是在对角线上 因为形成了一个正方形
            //如果两点的行之差(绝对值)等于列之差(绝对值) 那两点就在同一对角线上﻿
            if(Math.abs(queens[pos] - queens[i]) == Math.abs(pos - i)) return false;
        }
        return true;
    }
    
    public void addSolution(List<List<String>> result, int[] queens){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < queens.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < queens.length; j++){
                if(j == queens[i]) sb.append("Q");
                else sb.append(".");
            }
            list.add(sb.toString());
        }
        result.add(list);
    }
}
