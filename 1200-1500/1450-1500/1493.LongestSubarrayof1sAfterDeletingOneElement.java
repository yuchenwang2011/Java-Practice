1493. Longest Subarray of 1's After Deleting One Element
Medium 3.4K 56
Given a binary array nums, you should delete one element from it.
Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

Example 1:
Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

Example 2:
Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

Example 3:
Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.

Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.
Accepted 170.3K Submissions 256.3K Acceptance Rate 66.5%

Answer:
//followed this answer https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/solutions/3719568/beat-s-100-c-java-python-beginner-friendly/
class Solution {
    public int longestSubarray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int result = 0;
        int left = 0;
        int deleted = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] != 1) deleted++;

            //这里直接用if也行，但是很不好理解，就用while好了
            while(deleted > 1){ 
                if(nums[left] != 1) deleted--;
                left++;
            }

            if(deleted <= 1) {
                result = Math.max(result, right - left + 1 - deleted);
            }
        }

        //因为题目要求必须减掉一位，所以如果全是1的话，就减掉一个
        return (result == nums.length) ? result - 1 : result;
    }
}