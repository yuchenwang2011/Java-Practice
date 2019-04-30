33. Search in Rotated Sorted Array
Medium
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
Your algorithm's runtime complexity must be in the order of O(log n).
Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

class Solution {
    //https://www.youtube.com/watch?v=KSZfO65J6hg
    //this question is just to keep finding out the ascending half, otherwise not able to binary search
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            
            //if ascending half is on left side or on right side
            if(nums[start] < nums[mid]) {
                //if target is in left side ascending part, that's good, discard rest half
                if(nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    //give up left ascending part
                    start = mid;
                }
            } else {
                //if target is in right side ascending part, that's good, ,discard rest half
                if(nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    //give up right ascending part
                    end = mid;
                }
            }
        }
        
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }
}
