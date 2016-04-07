279. Perfect Squares My Submissions QuestionEditorial Solution
Total Accepted: 30631 Total Submissions: 95070 Difficulty: Medium
Given a positive integer n, find the least number of perfect square numbers 
(for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

Answer:
public class Solution {
    //I will use BFS to solve it next round, this round is dynamic programming
    //https://leetcode.com/discuss/57850/explanation-of-the-dp-solution
    //https://leetcode.com/discuss/62526/an-easy-understanding-dp-solution-in-java
    //https://leetcode.com/discuss/72205/java-dp-solution-with-explanation
    public int numSquares(int n) {
        if(n < 0) return 0;
        int[] dp = new int[n+1];
        //dp[0] = 1;
        for(int i = 1; i <= n; i++){
            int min = Integer.MAX_VALUE;
            int sqrt = (int) Math.sqrt(i);
            
            if(i == sqrt * sqrt) {
                dp[i] = 1;
                continue;
            }
            
            for(int j = 1; j * j < i; j++){
                min = Math.min(min, dp[i - j * j] + dp[j * j]);
            }
            dp[i] = min; 
        }
        //I finally understand why each time is dp[i - j * j] + 1, the 1 here means dp[j * j], it's smallest value must be 1
        //because itself is a square. To make a dp[] as small as possible, the minimum value is to delete a square from it
        //so dp[i - j*j] is guaranteed to be the smallest value already, the smallest possible value for dp[i]
        //is to add dp[i-j*j] + this dpp[j * j](1)
        return dp[n];
    }
}
