121. Best Time to Buy and Sell Stock My Submissions Question
Total Accepted: 81584 Total Submissions: 234488 Difficulty: Medium
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction 
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Answer: 
//https://www.youtube.com/watch?v=helrhutBYnk
class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        if(prices == null || prices.length < 2) return result;

        int minCost = prices[0];
        for(int price : prices){
            minCost = Math.min(minCost, price);
            result = Math.max(result, price - minCost); //这里想万一是今天的minCost怎么办，不要担心，那个是0，不会算入结果的
        }
        return result;
    }
}
