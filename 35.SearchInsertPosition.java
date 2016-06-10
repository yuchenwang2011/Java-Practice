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
public class Solution {
    //***This method needs hard memorize it.
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        
        int start = 0, end = nums.length-1;//(5/2=2)
        int mid = start + (end -start)/2; //same as (start+end)/2 but prevent overflow
        while( start <=end) {
            if(target < nums[mid]){
                end = mid-1;
            } else if (target > nums[mid]) {
                start = mid+1;
            } else {
                return mid;
            }
            mid = (start+end)/2;
        }
        return start;  //it's the most tricky part here, don't here which one of three to return
        //may not correct: as finally mid will be returned or start == end, so why nor return start
        //since [1,3,4,6,7,8], 5,after first separation, [6,7,8] will never match 5, at last, 
        //start == end, but still can't find it. then return start
        //[1,3,4,6,7,8],11, after first separation, [6,7,8] will never match 11, at last, 
        //start increases and then equal to end, but still not match. finally more than end
    }
}

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
