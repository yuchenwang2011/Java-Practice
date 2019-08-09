283. Move Zeroes My Submissions Question
Total Accepted: 46182 Total Submissions: 107690 Difficulty: Easy
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order 
of the non-zero elements.
For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.

Answer:
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int start = 0;
        for(int i =  0; i < nums.length; i++){
            if(nums[i] != 0) swap(nums, start++, i);
        }
    }
    public void swap(int[] nums, int start, int end){
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }
}
