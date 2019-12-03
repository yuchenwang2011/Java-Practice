96. Unique Binary Search Trees My Submissions Question
Total Accepted: 75378 Total Submissions: 204705 Difficulty: Medium
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

   Answer:
//https://www.youtube.com/watch?v=JrTKVvYhT_k
class Solution {
    public int numTrees(int n) {
        if(n <= 0) return 0;
        int[] dp = new int[n + 1]; //比如5 代表n=5能一共组成多少个组合
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            //dp[6] = dp[0] * dp[5] + dp[1] * dp[4] + dp[2] * dp[3] + ......
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
