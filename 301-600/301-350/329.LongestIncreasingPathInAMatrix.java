329. Longest Increasing Path in a Matrix
Hard

Given an integer matrix, find the length of the longest increasing path.
From each cell, you can either move to four directions: left, right, up or down. 
You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:
Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].

Example 2:
Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Accepted 117,358 Submissions 280,195

Answer:
//这个是我自己风格的修改版
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 1;
        int[][] lengths = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int length = helper(matrix, i, j, Integer.MIN_VALUE, lengths);
                result = Math.max(result, length);
            }
        }
        return result;
    }
    
    public int helper(int[][] matrix, int x, int y, int last, int[][] lengths){
        if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) return 0;
        if(matrix[x][y] <= last) return 0;
        if(lengths[x][y] != 0) return lengths[x][y];
        int cur = matrix[x][y];
        int a = helper(matrix, x + 1, y, cur, lengths) + 1;
        int b = helper(matrix, x - 1, y, cur, lengths) + 1;
        int c = helper(matrix, x, y - 1, cur, lengths) + 1;
        int d = helper(matrix, x, y + 1, cur, lengths) + 1;
        int max = Math.max(a, Math.max(b, Math.max(c, d)));
        lengths[x][y] = max;
        return max;
    }
}
