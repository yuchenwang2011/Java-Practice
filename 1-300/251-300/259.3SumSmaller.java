259. 3Sum Smaller My Submissions Question
Total Accepted: 5404 Total Submissions: 14570 Difficulty: Medium
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]
Follow up:
Could you solve it in O(n2) runtime?

Answer:
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int result = 0;
        if(nums == null || nums.length < 3) return result;
        
        Arrays.sort(nums);
        for(int first = 0; first < nums.length - 2; first++){
            int second = first + 1;
            int third = nums.length - 1;
            while(second < third){
                if(nums[first] + nums[second] + nums[third] >= target) third--;
                else {
                    //注意：这里最重要。从third现在这里，third一直往前走到second的后一位，sum全都小于target
                    result += third - second;
                    //加1了以后就没准比target大了，所以也是要重新来一遍的
                    second++;
                }
            }
        }
        
        return result;
    }
}
