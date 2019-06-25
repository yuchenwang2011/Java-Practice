15. 3Sum My Submissions Question
Total Accepted: 95873 Total Submissions: 533923 Difficulty: Medium
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)

Answer:
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //****Remember the syntax for List<List<Integer>> whole line
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2 ; i++){
            int start = i+1, end = nums.length-1;
            
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            
            while(start < end){
                if(start < end && nums[i] + nums[start] + nums[end] == 0){
                    while(start < end && nums[start] == nums[start+1]){
                      start++;
                    }
                    while(start < end && nums[end] == nums[end-1]) {
                      end--;
                    }
                    result.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    start++;end--;
                } else if (start < end && nums[i] + nums[start] + nums[end] > 0){
                    end--;
                } else if (start < end && nums[i]+nums[start]+nums[end] <0) {
                    start++;
                }
            }
        }
        return result;
    }
}

//This is my answer second round
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        for(int first = 0; first < nums.length - 2; first++){
            int start = first + 1, end = nums.length -1;
            if(first > 0 && nums[first] == nums[first-1]) continue;
            while(start < end) {
                int sum = nums[first] + nums[start] + nums[end];
                if(sum > 0) end--;
                else if (sum < 0) start++;
                else {
                    while(start < end && nums[start] == nums[start + 1]) start++;
                    while(start < end && nums[end] == nums[end-1]) end--;
                    result.add(Arrays.asList(nums[first], nums[start], nums[end]));
                    start++; end--;
                }
            }
        }
        return result;
    }
}
