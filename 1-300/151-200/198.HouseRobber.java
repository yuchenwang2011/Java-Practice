198. House Robber My Submissions QuestionEditorial Solution
Total Accepted: 64620 Total Submissions: 189564 Difficulty: Easy
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that 
adjacent houses have security system connected 
and it will automatically contact the police 
if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.

Answer:
public class Solution {
    //It's easy to optimize it to Space O(1), 
    //just use 2 variables to represent dp[i-2] and dp[i-1], then 往下撸
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        //alert: here it's easy to make mistake
        dp[1] = Math.max(nums[1],nums[0]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1] + 0);
        }
        return dp[nums.length - 1];
    }
}

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int first = nums[0];
        int second = Math.max(first, nums[1]);
        int result = Math.max(first, second);
        for(int i = 2; i < nums.length; i++){
            result = Math.max(first + nums[i], second + 0);
            first = second;
            second = result;
        }
        return result;
    }
}
