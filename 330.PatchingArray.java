330. Patching Array   My Submissions QuestionEditorial Solution
Total Accepted: 8140 Total Submissions: 28128 Difficulty: Medium
Given a sorted positive integer array nums and an integer n, 
add/patch elements to the array such that any number in range [1, n] inclusive 
can be formed by the sum of some elements in the array. Return the minimum number of patches required.

Example 1:
nums = [1, 3], n = 6
Return 1.

Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.

Example 2:
nums = [1, 5, 10], n = 20
Return 2.
The two patches can be [2, 4].

Example 3:
nums = [1, 2, 2], n = 5
Return 0.

Answer:
public class Solution {
    //Got inspired by first link's idea and the java code answer below, and the coding from second link
    //https://leetcode.com/discuss/83272/share-my-thinking-process
    //https://leetcode.com/discuss/82822/solution-explanation
    public int minPatches(int[] nums, int n) {
        if(nums == null || n == 0 ) return 0;
        long range = 0;
        int patch  = 0, i = 0;
        while(range < n){
            if(i < nums.length && nums[i] <= range + 1) range += nums[i++];
            else {
                range = range + 1 + range;
                patch ++;
            }
        }
        return patch;
    }
}
