70. Climbing Stairs My Submissions QuestionEditorial Solution
Total Accepted: 103990 Total Submissions: 284101 Difficulty: Easy
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Answer:
//this is my own dp solution
class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
}

public class Solution {
    //This O(1) space solution maybe hard to understand, it's derived from the O(N) solution
    public int climbStairs(int n) {
        if(n == 0) return 0;
        
        int result = 1; 
        int oneStep = 1, twoStep = 1;
        
        //calcuate how many ways to get to the ith step
        for(int i = 2; i <= n; i++){
            result = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = result;
        }
        
        return result;
    }
}
