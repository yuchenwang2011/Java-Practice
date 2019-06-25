35. Search Insert Position My Submissions Question
Total Accepted: 89239 Total Submissions: 244243 Difficulty: Medium
Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

Answer:
//this is my second round answer
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        if(target < nums[0]) return 0;
        if(target > nums[nums.length - 1]) return nums.length;
        int start = 0, end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            else if (nums[mid] < target) start = mid;
            else end = mid;
        }
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return start+1;
    }
}
