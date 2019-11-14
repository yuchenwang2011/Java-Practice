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
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        
        //在前两天，buy是在第i天以buy结尾
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[0], -prices[1]);       
        sell[0] = 0;
        sell[1] = Math.max(0, prices[1] - prices[0]);
        
        for(int i = 2; i < prices.length; i++){
            int price = prices[i];
            //在两天以后，buy就是意味着buy还是不买了，要辩证的分段的看
            //buy的意义不是一成不变的
            buy[i] = Math.max(sell[i - 2] - price, buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + price, sell[i - 1]);
        }
        return sell[sell.length - 1];
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
