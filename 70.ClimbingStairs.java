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

class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        
        int result = 0;
        
        int oneStepBefore = 1;
        int twoStepBefore = 1;
        
        for(int i = 2; i <= n; i++){
            result = oneStepBefore + twoStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = result;
        }
    
        return result;
    }
}
