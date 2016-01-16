121. Best Time to Buy and Sell Stock My Submissions Question
Total Accepted: 81584 Total Submissions: 234488 Difficulty: Medium
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction 
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Answer: 
public class Solution {
    //this question is very easy to implement but hard to understand
    //why we bought on first day and then find second day cheaper, then change our cost to second day's price
    //and we won't know if there will be a higher price tomorror to make more profit
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length ==0 || prices.length ==1) {
            return 0; //as no buy and no sell is profit 0
        }
        int min = prices[0]; int profit = 0;
        for (int i = 0 ;  i < prices.length ; i++) {
            if (prices[i] < min) {
                min = prices[i];  //find the minimum price
            } else {
                profit = Math.max(profit, prices[i]-min);
            }
        }
        return profit;
    }
}
