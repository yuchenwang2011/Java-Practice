268. Missing Number My Submissions Question
Total Accepted: 33560 Total Submissions: 87633 Difficulty: Medium
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.
Note:
Your algorithm should run in linear runtime complexity. 
Could you implement it using only constant extra space complexity?

Answer:
public class Solution {
    public int missingNumber(int[] nums) {
      //https://leetcode.com/discuss/56174/3-different-ideas-xor-sum-binary-search-java-code
      //Bit Manipulation Method: n ^ n = 0 and n ^ 0 = n 
      //I willl do a binary search method next round
    int result = 0;
    for (int i = 1; i <= nums.length; i++) {
        result = result ^ nums[i-1];
        result = result ^ i;
    }
    return result;
    }
    //just think, if you missed 0, you still have 1...n to xor 1...n, to be zero, then return zero;
    //if not zero, you have 1..n-1 to xor 1..n, that's 0^n=n, return n;
}
