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
    
    
========================================
Answer:
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        //there are some solutions using once left search and once right search
        //I will try it next time
        int[] result = new int[]{-1,-1};
        if (nums == null | nums.length == 0){
            return result;
        }
        if(target < nums[0]){
            return result;
        }
        if(target > nums[nums.length-1]){
            return result;
        }
        int left = -1, right = -1;
        
        double target1 = target - 0.5, target2 = target + 0.5;
        left = binarySearch(nums,0,nums.length-1,target1);
        right = binarySearch(nums,0,nums.length-1,target2);
        if(nums[left] != target){
            left++;
        }
        if(nums[right] == target){
          result[0] = left; result[1] = right; 
        } 
        return result;
    }
    public int binarySearch(int[] nums, int start, int end, double target){
        if(target < nums[start]){
            return start;
        }
        if(target > nums[nums.length-1]){
            return end;
        }
        while(start < end -1){
            int mid = start + (end-start)/2;
            if(target < nums[mid]){
                end = mid;
            } else if(target > nums[mid]) {
                start = mid;
            }
        }
        return start;
    }
    
}
