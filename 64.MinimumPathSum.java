64. Minimum Path Sum My Submissions Question
Total Accepted: 61258 Total Submissions: 180794 Difficulty: Medium
Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Answer:
public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int row = grid.length, column = grid[0].length;
        if(column == 0){
            return 0;
        }
        int[] dp = new int[column];
        for(int i =0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(j ==0){
                    dp[j] = dp[j] + grid[i][j];
                    continue;
                } 
                if(i != 0 ){
                    dp[j] = Math.min(dp[j-1]+grid[i][j],dp[j]+grid[i][j]);
                } else {
                    dp[j] = dp[j-1] + grid[i][j];
                }
            }
        }
        return dp[column-1];
    }
}
//[[1]],[[1,3,1],[1,5,1],[4,2,1]]
