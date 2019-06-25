259. 3Sum Smaller My Submissions Question
Total Accepted: 5404 Total Submissions: 14570 Difficulty: Medium
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]
Follow up:
Could you solve it in O(n2) runtime?

Answer:
import java.util.*;
public class Solution {
    //I was inspired by this answer 
    //https://leetcode.com/discuss/63016/accepted-and-simple-java-solution-with-detailed-explanation
    //*******Remember the syntax for Arrays.sort(nums)
    public int threeSumSmaller(int[] nums, int target) {
      int count = 0;
      if(nums.length < 3 || nums == null) {
        return 0;   
      }
      Arrays.sort(nums);
      for (int i =0; i <= nums.length-3; i++) {
         int low = i+1; int hi = nums.length-1;
         while(low < hi) {
           if(nums[i] + nums[low] + nums[hi] < target) {
             count = count + (hi - low); 
             low++;
           } else {
             hi--;  
           }
         }
      }
      return count;
    }
}
