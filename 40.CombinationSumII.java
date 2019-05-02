40. Combination Sum II My Submissions Question
Total Accepted: 59121 Total Submissions: 220944 Difficulty: Medium
Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.
Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 

Answer: 
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        Arrays.sort(candidates);
        if(target < candidates[0]) return result;
        dfs(candidates, target, tmp, result, 0);
        return result;
    }
    
    public void dfs(int[] nums, int target, List<Integer> tmp, List<List<Integer>> result, int idx){
        if(target < 0) return;
        if(target ==0) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = idx; i < nums.length; i++){
            tmp.add(nums[i]);
            dfs(nums,target-nums[i],tmp,result,i+1);
            //this line can be put here and next line but not previous
            //because you have to include the very first situation, which this tmp answer has many duplicates numbers
            //but after that, this element should not be used anymore
            while(i< nums.length-1 && nums[i+1] == nums[i]) i++; 
            tmp.remove(tmp.size()-1);
        }
    }
}
