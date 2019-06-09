154. Find Minimum in Rotated Sorted Array II
Hard

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
Find the minimum element.
The array may contain duplicates.

Example 1:
Input: [1,3,5]
Output: 1
Example 2:

Input: [2,2,2,0,1]
Output: 0
Note:
This is a follow up problem to Find Minimum in Rotated Sorted Array.
Would allow duplicates affect the run-time complexity? How and why?

Answer:
class Solution {
    public int findMin(int[] nums) {
        int result = Integer.MAX_VALUE;
        if(nums == null || nums.length == 0) return result;
        
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            while(start + 1 < end && nums[start] == nums[start + 1]) {
                start++;
            }
            while(start + 1 < end && nums[end] == nums[end - 1]){
                end--;
            }
            if(start + 1 >= end) break;
            
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                return nums[mid];
            } else if (nums[mid] < nums[end]){
                end = mid;
            } else {
                //at least left of mid side are not the smallest
                start = mid + 1;
            }
        }
        
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }
}
