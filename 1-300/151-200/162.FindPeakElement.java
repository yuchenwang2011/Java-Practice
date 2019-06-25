162. Find Peak Element My Submissions Question
Total Accepted: 54742 Total Submissions: 167568 Difficulty: Medium
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.

Answer:
//use my template this question can be very easy
public class Solution {
       public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            } else if(nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]){
                start = mid;
            } else {
                end = mid;
            }
        }  
        return nums[start] < nums[end] ? end : start;
    }
}
