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
//I got inspired by this video, it's amazing so good, though its code is bad
//https://www.youtube.com/watch?v=JrTKVvYhT_k
public class Solution {
    public int numTrees(int n) {
        if(n==0) return 1;
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; i++){ //this for loop is to save dp elements
            for(int j = 0; j <= i-1; j++){
                dp[i] = dp[i] + dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }
}