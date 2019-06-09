153. Find Minimum in Rotated Sorted Array My Submissions Question
Total Accepted: 76600 Total Submissions: 218009 Difficulty: Medium
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.

Answer:
class Solution {
    public int findMin(int[] nums) {
        int result = Integer.MAX_VALUE;
        if(nums == null || nums.length == 0) return result;
        
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] <= nums[mid + 1] && nums[mid] <= nums[mid - 1]) {
                return nums[mid];
            } else if(nums[mid] < nums[end]){
                end = mid;
            } else {
                start = mid;
            }
        }
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }
}
