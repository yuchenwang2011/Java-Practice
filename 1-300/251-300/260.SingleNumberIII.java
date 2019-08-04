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
        //In the first pass, we XOR all elements in the array, and get the XOR of the two numbers we need to find. 
        //Note that since the two numbers are distinct, so there must be a set bit (that is, the bit with value '1') in the XOR result.
        //Find out an arbitrary set bit (for example, the rightmost set bit).
        diff &= -diff; //get the right most 1, use a number to try yourself
        for(int num : nums){
            //In the second pass, we divide all numbers into two groups, one with the aforementioned bit set, 
            //another with the aforementinoed bit unset. Two different numbers we need to find must fall into thte two distrinct groups. 
            //XOR numbers in each group, we can find a number in either group.
            if((num & diff) == 0) result[0] ^= num;
            else result[1] ^= num;
        }
        return result;
    }
}
