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
//First O(N) method:
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //The O(N) solution: two pointer is actually a window
        //https://leetcode.com/discuss/74489/1-ms-o-n-time-solution-in-java-dynamic-sliding-window
        //https://leetcode.com/discuss/67345/java-concise-solution-with-o-n-complexity
        //https://leetcode.com/discuss/45449/accepted-clean-java-o-n-solution-two-pointers
        
        //The O(NlogN) solution:
        //https://leetcode.com/discuss/35335/o-nlgn-is-not-that-easy-here-is-my-java-code
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
