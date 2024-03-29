1679. Max Number of K-Sum Pairs
Medium 2.6K 59

You are given an integer array nums and an integer k.
In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
Return the maximum number of operations you can perform on the array.

Example 1:
Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.

Example 2:
Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
 
Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= 109
Accepted 165.2K Submissions 294.7K Acceptance Rate 56.0%

Answer:
//https://leetcode.com/problems/max-number-of-k-sum-pairs/solutions/2007455/java-2-approaches-100-two-pointer-sorting-hashmap
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int sum = nums[start] + nums[end];
            if(sum > k) {
                end--;
            } else if (sum < k){
                start++;
            } else {
                result++;
                start++;
                end--;
            }
        }
        return result;
    }
}

class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(k-nums[i]) && map.get(k-nums[i])>0){
                count++;
                map.put(k - nums[i], map.get(k - nums[i]) - 1);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return count;
    }
}
