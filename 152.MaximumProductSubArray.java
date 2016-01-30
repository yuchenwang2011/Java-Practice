152. Maximum Product Subarray My Submissions Question
Total Accepted: 50567 Total Submissions: 237092 Difficulty: Medium
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

Answer:
public class Solution {
    public int maxProduct(int[] nums) {
      //I was inspired by first answer, second one is also good
      //https://leetcode.com/discuss/11923/sharing-my-solution-o-1-space-o-n-running-time
      //https://leetcode.com/discuss/44573/accepted-java-solution
      if (nums == null || nums.length == 0) {
          return 0;
      }   
      int result = nums[0];
      int maxTemp = nums[0], minTemp = nums[0];
      int maxHere, minHere;
      for(int i = 1; i< nums.length; i++) {
          maxHere = Math.max(nums[i],Math.max(minTemp*nums[i], maxTemp*nums[i]));
          minHere = Math.min(nums[i],Math.min(minTemp*nums[i], maxTemp*nums[i]));
          //Following line is not correct, because maxTemp is just updated, you need to use the old one
          //minTemp = Math.min(nums[i],Math.min(minTemp*nums[i], maxTemp*nums[i]));
          result = Math.max(maxHere,result);
          maxTemp = maxHere; minTemp = minHere;
      }
      return result;
    }
}
//Test case: [-2],[-4,-3,-2]
