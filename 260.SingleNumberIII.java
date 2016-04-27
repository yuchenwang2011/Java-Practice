260. Single Number III   My Submissions QuestionEditorial Solution
Total Accepted: 32426 Total Submissions: 74196 Difficulty: Medium
Given an array of numbers nums, in which exactly two elements appear only once 
and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

Answer:
public class Solution {
    //Got inspired by this answer, impossible to think up an answer by myself
    //https://leetcode.com/discuss/52351/accepted-java-space-easy-solution-with-detail-explanations
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        if(nums == null || nums.length < 2) return result;
        int diff = 0;
        for(int num : nums){
            diff ^= num;
        }
        diff &= -diff; //get the right most 1, use a number to try yourself
        for(int num : nums){
            if((num & diff) == 0) result[0] ^= num;
            else result[1] ^= num;
        }
        return result;
    }
}
