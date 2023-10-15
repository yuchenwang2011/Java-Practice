39. Combination Sum My Submissions Question
Total Accepted: 77994 Total Submissions: 261112 Difficulty: Medium
Given a set of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. 
(ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 

Answer:
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0 || target < candidates[0]) return result;
        Arrays.sort(candidates);
        helper(candidates, result, new ArrayList<>(), target, 0);
        return result;
    }
    
    public void helper(int[] nums, List<List<Integer>> result, List<Integer> tmp, int target, int idx){
        if(idx >= nums.length) return;
        if(target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        if(target < 0) return;
        for(int i = idx; i < nums.length; i++){
            tmp.add(nums[i]);
            helper(nums, result, tmp, target - nums[i], i);
            tmp.remove(tmp.size() - 1);
        }
    }
}
