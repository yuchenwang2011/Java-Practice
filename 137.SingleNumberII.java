137. Single Number II   My Submissions QuestionEditorial Solution
Total Accepted: 81941 Total Submissions: 217895 Difficulty: Medium
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Answer:
public class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] count = new int[32];
        for(int i = 0; i < 32; i++){
            for(int j = 0; j < nums.length; j++){
                count[i] += (nums[j] >> i) & 1; 
            }
            count[i] = count[i] % 3;
        }
        int result = 0;
        for(int i = 0; i < 32; i++){
            result |=  count[i] << i;
        }
        return result;
    }
}