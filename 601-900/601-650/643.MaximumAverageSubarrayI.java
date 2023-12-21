643. Maximum Average Subarray I
Easy 2.9K 237
You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. 
Any answer with a calculation error less than 10-5 will be accepted.

Example 1:
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

Example 2:
Input: nums = [5], k = 1
Output: 5.00000
 
Constraints:
n == nums.length
1 <= k <= n <= 105
-104 <= nums[i] <= 104
Accepted 272.8K Submissions 631.2K Acceptance Rate 43.2%

Answer:
//my own answer but fixed a test case after reading 
//https://leetcode.com/problems/maximum-average-subarray-i/solutions/105432/java-solution-sum-of-sliding-window/
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0) return 0;
        if(k >= nums.length) return Arrays.stream(nums).sum() / (double) nums.length;

        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }

        int maxSum = sum;
        int i = 1;
        while(i + k - 1 < nums.length){
            sum = sum - nums[i - 1] + nums[i + k - 1]; 
            maxSum = Math.max(maxSum, sum);
            i++;
        }

        return maxSum / (double) k;
    }
}
