1004. Max Consecutive Ones III
Medium 7.4K 83
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Example 2:
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 
Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
Accepted 354.4K Submissions 563.5K Acceptance Rate 62.9%

Answer:
//followed the comment in this answer https://leetcode.com/problems/max-consecutive-ones-iii/solutions/247564/java-c-python-sliding-window/
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int result = 0;
        int zeros = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0) zeros++;

            //这里用if也行，但是不好理解，就用while好了
            while(zeros > k){
                if(nums[left] == 0) zeros--;
                left++;
            }

            if(zeros <= k) { //这个if可以不要，但是一下就理解不了了，所以还是加上
                result = Math.max(result, right - left + 1);
            }
        }

        return result;
    }
}
