238. Product of Array Except Self My Submissions Question
Total Accepted: 29401 Total Submissions: 72869 Difficulty: Medium
Given an array of n integers where n > 1, nums, return an array output such that output[i] 
is equal to the product of all the elements of nums except nums[i].
Solve it without division and in O(n).
For example, given [1,2,3,4], return [24,12,8,6].
Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space 
for the purpose of space complexity analysis.)

Answer:
public class Solution {
    //use nums = [2,3,4,5,6] to try it out on paper you will understand
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int multiplier = 1;
        if(nums == null || nums.length ==0) {
            return null;
        }
        for(int left=0; left < nums.length; left++) {
            result[left] = multiplier;
            multiplier *= nums[left];
        }
        multiplier = 1;
        for(int right=nums.length-1; right >= 0; right--){
            result[right] *= multiplier;
            multiplier *= nums[right];
        }
        return result;
    }
}
