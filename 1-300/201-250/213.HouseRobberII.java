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
public class Solution {
    //Just 2 solutions, don't rob last one, don't rob first one, so the quesion becomes two lines
    //https://leetcode.com/discuss/36544/simple-ac-solution-in-java-in-o-n-with-explanation
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int length = nums.length;
        if(length == 1) return nums[0];
        return Math.max( robHelper(nums, 0, length - 2), robHelper(nums, 1, length -1 ) );
    }
    
    public int robHelper(int[] nums, int i, int j){
        if(j - i < 1) return nums[i];
        int first = nums[i], second = Math.max(nums[i], nums[i+1]);
        for(int a = i+2; a <= j; a++){
            int result = Math.max(first + nums[a], second + 0);
            first = second;
            second = result;
        }
        return second;
    }
}
