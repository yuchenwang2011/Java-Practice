209. Minimum Size Subarray Sum My Submissions Question
Total Accepted: 28594 Total Submissions: 111222 Difficulty: Medium
Given an array of n positive integers and a positive integer s, 
find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

More practice:
If you have figured out the O(n) solution, 
try coding another solution of which the time complexity is O(n log n).

Answer:
//two pointer question
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int start = 0; int sum = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            while(sum >= s){
               min = Math.min(min,i-start+1); 
               sum = sum - nums[start];
               start++;
            }
        }
        return min == Integer.MAX_VALUE? 0:min;
    }
}
