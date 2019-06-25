122. Best Time to Buy and Sell Stock II My Submissions Question
Total Accepted: 73420 Total Submissions: 179811 Difficulty: Medium
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).

Anwer:
//this is my second round solution
public class Solution{
  public int maxProfit(int[] nums){
    if(nums == null || nums.length <= 1) return 0;
    int result = 0, i = 0;
    while(i < nums.length){
       while(i < nums.length-1 && nums[i+1] <= nums[i]) i++;
       int min = nums[i];
       while(i < nums.length-1 && nums[i+1] >= nums[i]) i++;
       int max = nums[i];
       result += max - min;
       i++;
    }
    return result;
  }
}

//Solution May 27 2019.
class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        if(prices == null || prices.length < 2) return result;

        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1]) {
                result += prices[i] - prices[i - 1];
            }
        }
        return result;
    }
}
