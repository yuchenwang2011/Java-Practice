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
//result里每一个数都等于左边的数组乘积再乘以右边的数组乘积
//所有比如12345，3那个位置的结果，就是左边12再乘以右边的45。5的话就相当于1234相乘
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0]; 
        int[] result = new int[nums.length];
        Arrays.fill(result, 1); //it's also ok to have result[0] = 1;
        
        for(int i = 1; i < nums.length; i++){
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        int right = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
}
