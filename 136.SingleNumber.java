136. Single Number My Submissions QuestionEditorial Solution
Total Accepted: 121560 Total Submissions: 246694 Difficulty: Medium
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Answer:
public class Solution {
    //The explanation is this link and this question is almost the same as 268
    //https://leetcode.com/discuss/53327/easy-java-solution-tell-you-why-using-bitwise-xor
    //One method is to put every element into HashMap, then find the only one with size 1 because others should be 2
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }
}
