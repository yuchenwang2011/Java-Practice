213. House Robber II My Submissions QuestionEditorial Solution
Total Accepted: 26541 Total Submissions: 87027 Difficulty: Medium
Note: This is an extension of House Robber.

After robbing those houses on that street, 
the thief has found himself a new place for his thievery 
so that he will not get too much attention. This time, 
all houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. 
Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing 
the amount of money of each house, determine the maximum amount 
of money you can rob tonight without alerting the police.

Answer:
//either don't rob last one, either don't rob first one, so the quesion becomes two options
//the helper is same as question 1
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(helper(nums, 0, nums.length - 1), helper(nums, 1, nums.length));
    }
    
    public int helper(int[] nums, int start, int end){
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        int result = second;
        for(int i = start + 2; i < end; i++){
            result = Math.max(first + nums[i], second);
            first = second;
            second = result;
        }
        return result;
    }
}
