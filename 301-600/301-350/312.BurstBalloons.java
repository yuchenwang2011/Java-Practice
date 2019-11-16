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
//这个是最好的方法O(N^3)
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
        for(int length = 1; length <= nums.length; length++){
            //left + len + 1就是right的位置，也就是说，right最多就是n长度那么大
            for(int left = 1; left + length - 1 <= nums.length; left++){
                int right = left + length - 1;
                for(int x = left; x <= right; x++){
                    int tmp = dp[left][x - 1] + dp[x + 1][right] + vals[left - 1] * vals[x] * vals[right + 1];
                    dp[left][right] = Math.max(dp[left][right], tmp);
                }
            }
        }
        return dp[1][nums.length];
    }
}


/**
 * Extend nums by 2, then we can guarantee that every balloon can have three-products, even though we only have
 * one or two balloons left.
 *
 * Sub-problem: dp(i, j) stores the maximum coins we can get from index i to j, we will have another scanning
 * pointer k between i and j, to find the best position of last bursting balloon with max coins we could get
 * Base case: dp(0, 0) = 0, dp(n + 1, n + 1) = 0; n is the size of input array
 * Recurrence relation: dp(i, j) = Max(i <= k <= j) (dp(i, k-1) + nums[i-1] * numi[k] * nums[j+1] + dp(k+1, j))
 * Return: dp[1, n]
 * */

public int maxCoins(int[] nums) {
    if (nums == null || nums.length == 0) {
        return 0;
    }

    int n = nums.length;
    /** extend the input array by 2, to virtually add two invisible balloons at the front and end with value 1
     * so that two balloons at left and right boundary can have product with these two virtual balloons */
    int[] newNums = new int[n + 2];
    newNums[0] = 1;
    newNums[n + 1] = 1;
    for (int i = 0; i < n; i++) {
        newNums[i + 1] = nums[i];
    }

    //we need to extend length of dp array as well
    int[][] dp = new int[n + 2][n + 2];

    /** in order to solve larger problems, we need to solve smaller sub-problems firstly. we start from len 1 to
     * len n to solve each sub-problems */
    for (int len = 1; len <= n; len++) {

        //i is left pointer, j is right pointer, the length from i to j is fixed, i.e.: i + len - 1;
        for (int i = 1; i <= n - len + 1; i++) {
            int j = i + len - 1;

            /** k means the position of last balloon (that will burst) when we have fixed left and right pointer,
             * we need to move k from left to right to find the best k position to get max coins. From i to k - 1
             * (left of k) and k + 1 to j (right of k), we can get max value from previous sub-problems, so that
             * we can dynamically calculate max value of max(left + nums[i - 1] * nums[k] * nums[j + 1] + right) */

            for (int k = i; k <= j; k++) {
                dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + newNums[i - 1] * newNums[k] * newNums[j + 1] + dp[k + 1][j]);
            }
        }
    }

    /** WARNING: DO NOT RETURN dp[0][n - 1] because we already extend the dp size by 2, the valid number in dp
     * array is from index 1 to index n, which is also the max valid length that we could get in dp array dp[0][*].
     * In addition, dp[*][n + 1] should be 0, since we never assign any valid value to there */

    return dp[1][n];
}






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
