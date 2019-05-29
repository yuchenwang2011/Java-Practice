128. Longest Consecutive Sequence
Hard

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.
Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Answer:
class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        if(nums == null || nums.length == 0) return result;
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        for(int n : nums){
            int lower = n - 1;
            int upper = n + 1;
            while(set.contains(lower)){
                set.remove(lower);
                lower--;
            }
            while(set.contains(upper)){
                set.remove(upper);
                upper++;
            }
            result = Math.max(result, upper - lower - 1);
        }
        return result;
    }
}
