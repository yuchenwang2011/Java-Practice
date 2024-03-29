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
//改用了我在grind75 sliding window里的模板
class Solution {
    public int longestOnes(int[] nums, int k) {
        int result = 0;
        if(nums == null || k < 0) return result;
        
        int count = 0;
        int start = 0;
        int end = 0;
        
        while(end < nums.length){
            if(nums[end] == 0) count++;
            end++;

            while(count > k){
                if(nums[start] == 0) count--;
                start++;
            }
            
            if(end - start > result) {
                result = end - start;
            }
        }

        return result;
    }
}
