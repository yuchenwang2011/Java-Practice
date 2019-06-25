16. 3Sum Closest My Submissions Question
Total Accepted: 63743 Total Submissions: 226905 Difficulty: Medium
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
    For example, given array S = {-1 2 1 -4}, and target = 1.
    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Answer: 
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        //should guarantee the nums has at least 3 elements;
        int result = nums[0] + nums[1] + nums[nums.length-1];
        for (int i =0; i< nums.length-2; i++) {
          int a = i, b = i+1, c = nums.length-1;
          while (b < c) {
              int sum = nums[a]+nums[b]+nums[c];
              if(sum > target) {
                  c--;
              } else {
                  b++;
              }
              if(Math.abs(result-target) > Math.abs(sum-target)){ //It's a little tricky here
                  result = sum;
              }
          }
        }
        return result;
    }
}

//this is my second round answer
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE, sum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i-1] == nums[i]) continue;
            int start = i + 1, end = nums.length -1;
            while(start < end){
                int val = nums[i] + nums[start] + nums[end];
                if(Math.abs(val - target) < min) {
                    min = Math.abs(val - target);
                    sum = val;
                }
                if(val == target) return val;
                else if (val > target) end--;
                else start++;
            }
        }
        return sum;
    }
}
