34. Search for a Range My Submissions Question
Total Accepted: 70993 Total Submissions: 250040 Difficulty: Medium
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

//May1 2019: only need to remember this solution
//https://www.youtube.com/watch?v=pZ7ypg3mU64
public class Solution{
    public int[] searchRange(int[] nums, int target){
        int[] result = new int[]{-1,-1};
        if(nums == null || nums.length == 0) return result;
        result[0] = searchLeft(nums, target);
        result[1] = searchRight(nums, target);
        return result;
    }

    public int searchLeft(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(target <= nums[mid]) {
                end = mid;
            } else {
                start =mid;
            }
        }
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;

        return -1;
    }

    public int searchRight(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(target < nums[mid]){
                end = mid;
            } else {
                start = mid;
            }
        }

        if(nums[end] == target) return end;
        if(nums[start] == target) return start;

        return -1;
    }
}
