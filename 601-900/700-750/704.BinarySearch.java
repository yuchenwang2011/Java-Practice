704. Binary Search
Easy 11K 222

Given an array of integers nums which is sorted in ascending order, 
  and an integer target, write a function to search target in nums. 
  If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

Constraints: 
1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.
Accepted 2.1M Submissions 3.6M Acceptance Rate 56.8%

Answer:
//my own solution
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if(nums[start] == target) return start;
        return -1;
    }
}

//回忆的左闭右开的写法
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if(start < nums.length && nums[start] == target) return start;
        return -1;
    }
}
