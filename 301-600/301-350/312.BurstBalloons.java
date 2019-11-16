312. Burst Balloons
Hard


Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. 
You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:
You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:
Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
Accepted
76,916 Submissions 156,589

Answer:
class Solution {
    //dp[i][j]就是指气球从i到j被弄爆最后结果能得到的最大值
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] vals = new int[nums.length + 2];
        for(int i = 0; i < vals.length; i++){
            if(i == 0 || i == vals.length - 1) vals[i] = 1;
            else vals[i] = nums[i - 1];
        }

        int[][] dp = new int[vals.length][vals.length];
        return helper(vals, dp, 1, nums.length);
    }
    
    public int helper(int[] nums, int[][] dp, int i, int j){
        if(i > j) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        for(int x = i; x <= j; x++){
            //这里就是最后一步，左边的值 + 中间的值 + 右边的值
            //左边和右边的值都让循环去想，我就不管了，我只管中间的
            //中间的就是相当于i 和 j这片已经被爆了，所以得去i 和 j前面和后面的值去和这片剩下的最后x值相乘
            int tmp = helper(nums, dp, i, x - 1) + nums[i - 1] * nums[x] * nums[j + 1] +  helper(nums, dp, x + 1, j);
            dp[i][j] = Math.max(dp[i][j], tmp);
        }
        return dp[i][j];
    }
}
