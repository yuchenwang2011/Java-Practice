325. Maximum Size Subarray Sum Equals k My Submissions Question
Total Accepted: 4266 Total Submissions: 10938 Difficulty: Easy
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?

Answer:
public class Solution {
    //Got inspired by this answer, I feel really difficult
    //https://leetcode.com/discuss/77879/o-n-super-clean-9-line-java-solution-with-hashmap
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            if(sum == k) max = i + 1;
            // a = sum - k, that means , k = sum - a, --> currentSum - prevSum = k
            //means aaaxxxxx got a sum, xxxxx's sum is k, so delete the aaa part's sum, so the length = i - prev
            else if (map.containsKey(sum - k)) {
                int prev = map.get(sum-k);
                max = Math.max(max, i - prev );
            }
            if(!map.containsKey(sum)) map.put(sum,i);
        }
        return max;
    }
}
