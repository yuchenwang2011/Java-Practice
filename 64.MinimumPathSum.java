64. Minimum Path Sum My Submissions Question
Total Accepted: 61258 Total Submissions: 180794 Difficulty: Medium
Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Answer:
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int val = grid[i][j];
                if(i == 0 && j == 0) {
                    dp[i][j] = val;
                } else if(i == 0 || j == 0) {
                    if(i == 0) dp[i][j] = val + dp[i][j - 1];
                    if(j == 0) dp[i][j] = val + dp[i - 1][j];
                } else {
                    dp[i][j] = val + Math.min(dp[i][j - 1], dp[i - 1][j]);   
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}

//Optimized solution
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[] dp = new int[cols];
        
        dp[0] = grid[0][0];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int val = grid[i][j];
                if(i == 0 && j == 0) dp[j] = val;
                else if(i == 0 || j == 0) {
                    if(i == 0) dp[j] = val + dp[j - 1];
                    if(j == 0) dp[j] = val + dp[j];
                } else if(j > 0){
                    dp[j] = val + Math.min(dp[j], dp[j - 1]);   
                }
            }
        }
        return dp[dp.length - 1];
    }
}
//[[1]],[[1,3,1],[1,5,1],[4,2,1]]
