45. Jump Game II
Hard
Share
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.

Example:
Input: [2,3,1,1,4]
Output: 2

Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note: You can assume that you can always reach the last index.


Answer:
//http://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html
//https://github.com/yuchenwang2011/Java-Practice/blob/master/45.JumpGameII.PNG
/*
 * We use "last" to keep track of the maximum distance that has been reached
 * by using the minimum steps "ret", whereas "curr" is the maximum distance
 * that can be reached by using "ret+1" steps. Thus,
 * curr = max(i+A[i]) where 0 <= i <= last.
 */
class Solution {
    public int jump(int[] nums) {
        int ret = 0;
        int last = 0;
        int curr = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (i > last) {
                last = curr;
                ++ret;
            }
            curr = Math.max(curr, i+nums[i]);
        }

        return ret;
    }
}
