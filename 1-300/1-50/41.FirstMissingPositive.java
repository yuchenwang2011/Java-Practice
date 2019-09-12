41. First Missing Positive
Hard
Share
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:
Input: [1,2,0]
Output: 3

Example 2:
Input: [3,4,-1,1]
Output: 2

Example 3:
Input: [7,8,9,11,12]
Output: 1

Your algorithm should run in O(n) time and not uses constant extra space.

Answer:
//it uses bucket sort
//https://www.youtube.com/watch?v=jfb72FfxWKU 
class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        
        for(int i = 0; i < nums.length; i++){
            //here you can't reduce it to nums[i] - 1 != i  try [1,1]
            while(nums[i] >= 1 && nums[i] - 1 < nums.length && nums[nums[i] - 1] != nums[i]){
                //here is very tricky, you must save nums[nums[i] - 1] value first
                //otherwise you will overide the nums[i], then nums[nums[i] - 1] index will be wrong
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}
