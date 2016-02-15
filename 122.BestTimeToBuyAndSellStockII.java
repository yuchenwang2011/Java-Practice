122. Best Time to Buy and Sell Stock II My Submissions Question
Total Accepted: 73420 Total Submissions: 179811 Difficulty: Medium
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).

Anwer:
public class Solution {
    public int maxProfit(int[] prices) {
        //my test case [7,5,8,1,30,100,4,2,7,10,11]
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int lowPrice = prices[0], highPrice = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length ; i++) {
            while (i < prices.length && prices[i] <= lowPrice) { //first find the local lowest price
                lowPrice = prices[i];
                i++;   
            } // i should be 2 now, lowPrice = prices[1] = 5;
            highPrice = lowPrice;
            while (i < prices.length && prices[i] > highPrice) { 
                //Second, find the local highest price after the lowest price try to sell;
                highPrice = prices[i];
                i++;
            }
            //now i=3 and highPrice = prices[2] = 8;
            profit = profit + (highPrice - lowPrice);
            lowPrice = highPrice;
            i--; //Now we just loop through prices[2],8, but i is 3, next round it will be 4. We need check price[3]
        }
        return profit;
    }
}
