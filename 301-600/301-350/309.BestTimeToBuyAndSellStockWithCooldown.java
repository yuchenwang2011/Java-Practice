309. Best Time to Buy and Sell Stock with Cooldown   My Submissions QuestionEditorial Solution
Total Accepted: 13363 Total Submissions: 36526 Difficulty: Medium
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]

Answer:
public class Solution {
    public int maxProfit(int[] prices) {
        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75927/Share-my-thinking-process
        if(prices == null || prices.length <= 1) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[0], -prices[1]);
        
        sell[0] = 0;
        sell[1] = Math.max(0, prices[1] - prices[0]);
        
        for(int i = 2; i < prices.length; i++){
            buy[i] = Math.max(sell[i-2] - prices[i], buy[i-1]);
            sell[i] = Math.max( buy[i-1] + prices[i] , sell[i-1] );
        }
        return sell[prices.length - 1];
    }
}

//So just change the above answer from space O(N) to O(N), it becomes
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;

        int firstSell = 0;
        int lastBuy = Math.max(-prices[0], -prices[1]);
        int secondSell = Math.max(0, prices[1] - prices[0]);
        
        for(int i = 2; i < prices.length; i++){
            int buy = Math.max(firstSell - prices[i], lastBuy);
            int sell = Math.max(secondSell, lastBuy + prices[i]);
            lastBuy = buy;
            firstSell = secondSell;
            secondSell = sell;
        }
        return secondSell;
    }
}
