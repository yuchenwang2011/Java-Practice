18. 4Sum My Submissions Question
Total Accepted: 60600 Total Submissions: 264656 Difficulty: Medium
Given an array S of n integers, are there elements a, b, c, 
and d in S such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)

Answer:
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4) return result; 
        Arrays.sort(nums);
        for(int first = 0; first < nums.length - 3; first ++){
            if(first > 0 && nums[first] == nums[first - 1]) continue;
            for(int second = first + 1; second < nums.length -2; second++){
                //Be careful this line!!!!!!!!!
                if(second > first + 1 && nums[second] == nums[second-1]) continue;
                int start = second + 1, end = nums.length - 1;
                while(start < end) {
                    int val = nums[first] + nums[second] + nums[start] + nums[end];
                    if(val > target) end--;
                    else if (val < target) start++;
                    else {
                        while(start < end && nums[start] == nums[start+1]) start++;
                        while(start < end && nums[end] == nums[end-1]) end--;
                        result.add(Arrays.asList(nums[first], nums[second], nums[start], nums[end]));
                        start++; end--;
                    }
                }
            }
        }
        return result;
    }
}


=====================This is a K Sum KSum k sum ksum solution=============
https://leetcode.com/problems/4sum/discuss/8609/My-solution-generalized-for-kSums-in-JAVA
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4) return result; 
        Arrays.sort(nums);
        return nHelper(nums, 0, 4, target);
    }
    
    public List<List<Integer>> nHelper(int[] nums, int start, int k, int target){
        if(k == 2) return twoHelper(nums, start, target);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = start; i < nums.length - (k - 1); i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> last = nHelper(nums, i + 1, k - 1, target - nums[i]);
            for(List<Integer> list : last){
                list.add(0, nums[i]);
                result.add(list);
            }
        }
        return result;
    }
    
    public List<List<Integer>> twoHelper(int[] nums, int start, int target){
        List<List<Integer>> result = new ArrayList<>();
        int i = start;
        int j = nums.length - 1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum > target) j--;
            else if(sum < target) i++;
            else {
                while(i < j && nums[i] == nums[i + 1]) i++;
                while(i < j && nums[j] == nums[j - 1]) j--;
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[i]); 
                tmp.add(nums[j]);
                result.add(tmp);
                i++; j--;
            }
        }
        return result;
    }
}
