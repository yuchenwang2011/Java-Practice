322. Coin Change   My Submissions QuestionEditorial Solution
Total Accepted: 18860 Total Submissions: 76101 Difficulty: Medium
You are given coins of different denominations and a total amount of money amount. 
Write a function to compute the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.

Answer:
public class Solution {
    //Got inspired by this answer
    //https://leetcode.com/discuss/83289/understand-recursive-solution-using-java-with-explanations
    //Code below is the first slow answer, second answer is O(N)
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0) return -1;
        if(amount == 0) return 0;
        int result = amount + 1;
        for(int coin : coins){
            int currentMin = 0;
            if(amount >= coin){
                int leftNum = coinChange(coins, amount - coin);
                if(leftNum >= 0) currentMin = 1+ leftNum;
            }
            if(currentMin > 0) result = Math.min(result, currentMin);
        }
        return (result == amount + 1) ? -1 : result;
    }
}

public class Solution {
    //Read this cnb answer to understand how dp works
    //http://www.cnblogs.com/grandyang/p/5138186.html
    //https://leetcode.com/discuss/76204/simple-java-solution-o-amount-space-amount-time-complexity
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0) return -1;
        if(amount == 0) return 0;
        int[] dp = new int[amount + 1];
        
        //use i instead of currentAmount for simplicity, here just to make the idea clearer
        for(int currentAmount = 1; currentAmount <= amount; currentAmount++){
            dp[currentAmount] = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                //currentAmount's value is actually the current amount
                if(currentAmount >= coins[j]) {
                  int sub = currentAmount - coins[j];
                  if(dp[sub] != Integer.MAX_VALUE) dp[currentAmount] = Math.min(dp[currentAmount], dp[sub] + 1);
                }
            }
        }
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }
}
