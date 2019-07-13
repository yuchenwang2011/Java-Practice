188. Best Time to Buy and Sell Stock IV
Hard

Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).

Example 1:
Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

Example 2:
Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

Answer:
class Solution {
    //dp[i][j] 意思是在j天进行了i次操作，最多能有多少钱
    public int maxProfit(int k, int[] prices) {
        if(k <= 0) return 0;
        if(prices == null || prices.length == 0) return 0;
        if(k >= prices.length / 2) return unlimitedTransactionHelper(prices);
        
        int[][] dp = new int[k + 1][prices.length];
        for(int i = 1; i <= k; i++){
            int maxBalanceAfterTransactionLastRound = 0 - prices[0];
            for(int j = 1; j < prices.length; j++){
                //here prices[j] means to sell at this price, so it's a positive cash flow
                //cash income + balance = current money at hand
                dp[i][j] =  Math.max(dp[i][j - 1], maxBalanceAfterTransactionLastRound + prices[j]);
                //dp[i - 1][j - 1] 意思是前一天手里的最大钱数，为什么i - 1呢，
                //因为就是想比一下如果不操作，或者之前k - 1次操作但加上这次，等于k次操作，这两种哪个balance多
                //而且上一行算dp[i][j]是今天卖的操作。我们也得研究一下今天如果买，就是减去prices[j]，对于下一次的balance是有什么影响的
                maxBalanceAfterTransactionLastRound = Math.max(maxBalanceAfterTransactionLastRound, dp[i - 1][j - 1] - prices[j]);
            }
        }
        
        return dp[k][prices.length - 1];
    }
    
    public int unlimitedTransactionHelper(int[] prices){
        int result = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1]) {
                result += prices[i] - prices[i - 1];
            }
        }
        return result;
    }
}
