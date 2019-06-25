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


//我对上面算法的理解,比如5,1,3,1,1,1,1,1 结果是3 你先给了一个5,这个距离就老长了
//然后你就开始一步一步地去走，可能这个期间这个maxLength就被偷偷地更新成8了
//如果更新了，而且走到i=6时候，发现唉上次我缓存最大的那个最大5居然不够用了
//现在最新科技都更新到8了，我都落伍了
//没招了就得更新一下吧，步数也得加1了，也就是说你放弃了原来的走到第五步的走法
//在你接受了最大值是8的时候，你实际上已经换成了先5跳到3，然后从3跳的这种方式
class Solution {
    public int jump(int[] nums) {
        int result = 0;
        int maxLength = 0;
        int lastMaxLength = maxLength;
        
        if(nums == null || nums.length == 0) return result;
        
        for(int i = 0; i < nums.length; i++){
            if(i > lastMaxLength){
                lastMaxLength = maxLength;
                result++;
            }
            maxLength = Math.max(maxLength, nums[i] + i);
        }
        return result;
    }
}
