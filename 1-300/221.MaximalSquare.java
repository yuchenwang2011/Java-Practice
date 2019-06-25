221. Maximal Square   My Submissions QuestionEditorial Solution
Total Accepted: 28139 Total Submissions: 120181 Difficulty: Medium
Given a 2D binary matrix filled with 0's and 1's, 
find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.

Answer:
public class Solution {
    //Got inspired by this answer
    //https://leetcode.com/discuss/45207/accepted-clean-java-dp-solution
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row+1][col+1];
        int result = 0;
        
        //dp[i][j] represents the length of the square
        //whose lower-right corner is at [i][j]
        //if the value is 1, then dp[i][j] = min(dp(i-1,j-1), dp(i-1, j), dp(i, j-1)) + 1;
        
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min( dp[i-1][j] , dp[i][j-1] ));
                    result = Math.max(dp[i][j], result);
                }
            }
        }
        return result * result;
    }
}
