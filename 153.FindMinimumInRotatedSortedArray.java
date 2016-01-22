153. Find Minimum in Rotated Sorted Array My Submissions Question
Total Accepted: 76600 Total Submissions: 218009 Difficulty: Medium
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.

Answer:
public class Solution {
    public int findMin(int[] nums) {
        //C___DA___B where A<B<C<D
        //https://leetcode.com/discuss/45611/7-line-o-logn-solution
        //https://leetcode.com/discuss/45611/7-line-o-logn-solution
        //My idea is same as this one
        //https://leetcode.com/discuss/16260/java-solution-with-binary-search
        if(nums == null || nums.length ==0){
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length < 3){
            return Math.min(nums[0],nums[1]);
        }
        if(nums[0] < nums[nums.length-1]){ //for [1,2,3] case
            return nums[0];
        }
        int start = 0, end = nums.length-1;
        while(start < end ){
            int mid = start + (end -start)/2;
            if(nums[mid] < nums[0]){ //means mid is between A and B
                if(nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]){
                    return nums[mid];
                }
                end = mid-1;
            } else { //nums[mid] > nums[0]
                start = mid+1;
            }
        }
        return nums[start];
    }
}
