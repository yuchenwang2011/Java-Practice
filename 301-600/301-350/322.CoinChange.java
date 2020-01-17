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
//Time Limite exceeded
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(coins == null || coins.length == 0 || amount < 0) return -1;
        int result = Integer.MAX_VALUE;
        for(int coin : coins){
            if(amount >= coin) {
                int last = coinChange(coins, amount - coin);
                if(last != -1) result = Math.min(result, last + 1);
            }
        }    
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0) return -1;
        if(amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < dp.length; i++){
            for(int coin : coins){
                if(i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
