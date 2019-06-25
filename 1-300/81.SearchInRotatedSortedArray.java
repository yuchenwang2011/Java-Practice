81. Search in Rotated Sorted Array II
Medium
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

Example 2:
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false

Follow up:
This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?

Answer:
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int start = 0;
        int end = nums.length - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return true;
            
            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                start++;
                end--;
            } else if (nums[start] <= nums[mid]){
                //here you can write it target <= nums[mid] for simplicity but better not
                if(target >= nums[start] && target < nums[mid]) end = mid;
                else start = mid;
            } else {
                //nums[mid] <= nums[end]
                if(target > nums[mid] && target <= nums[end]) start = mid;
                else end = mid;
            }
        }
        if(nums[start] == target || nums[end] == target) return true;
        return false;
    }
}
