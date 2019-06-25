55. Jump Game My Submissions Question
Total Accepted: 68268 Total Submissions: 245966 Difficulty: Medium
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.
                                          ^^^^^^^
Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

Answer:
public class Solution {
 public boolean canJump(int[] nums) {
      //Inspired by this answer
      //https://leetcode.com/discuss/48551/6-line-java-solution-in-o-n
      int max = 0;
      for(int i =0; i< nums.length; i++){
          if (max < i){
              return false;
          } else {
              max = Math.max(max, i + nums[i]);
          }
      }
      return true;
    }
}
//Test case: [2,0],[2,5,0,0],[1,0,2],[2,0,0]
