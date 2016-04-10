300. Longest Increasing Subsequence My Submissions QuestionEditorial Solution
Total Accepted: 24448 Total Submissions: 71466 Difficulty: Medium
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

Answer:
public class Solution {
    //Got inspired by this answer: time complexity O(N^2)
    //https://www.youtube.com/watch?v=CE2b_-XfVDk
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int result = 1;
        int[] dp = new int[nums.length];
        
        for(int i = 0; i < dp.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            result = Math.max(dp[i], result);
        }
        
        return result;
    }
}
