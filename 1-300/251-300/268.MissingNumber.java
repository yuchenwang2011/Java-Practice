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
//需要掌握两种方法
class Solution {
    public int missingNumber(int[] nums) {
        int result = nums.length;    
        for(int i = 0; i < nums.length; i++){
            result ^= i ^ nums[i];
        }
        return result;
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int result = nums.length;   
        for(int i = 0; i < nums.length; i++){
            result += i - nums[i];
        }     
        return result;
    }
}
