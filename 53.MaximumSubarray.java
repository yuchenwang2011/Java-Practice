53. Maximum Subarray My Submissions Question
Total Accepted: 93288 Total Submissions: 260778 Difficulty: Medium
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.
More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

Answer:
This is a very very good video tutorial, which introduces 3 methods, 
https://www.youtube.com/watch?v=ohHWQf1HDfU
1.Kadane's Algorithm O(N)
2.Devide and Conquer O(Nlog(N))
3.Brute Force O(N^2)

//Kadane's Algorithm
//This method has even smarter implementation of Kadane's Algorithm, don't need 1 positive elment
//https://leetcode.com/discuss/51768/java-o-n-time-o-1-space-5-lines-of-code
//Let's say the test case is [1,-3,4,5,-5,-6,-7,-5,-1,5,6,2,4,7,11,-50]
public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int currentMax = nums[0]; int finalMax = nums[0];
        for(int i = 1; i < nums.length; i++){
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            finalMax = Math.max(currentMax, finalMax);
        }
        return finalMax;
    }
}
