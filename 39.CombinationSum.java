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
//I came up the idea myself but also got inspired by this answer
//http://blog.csdn.net/u011095253/article/details/9158423
public class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        if(target < nums[0]) return result;
        dfs(nums, target, result, new ArrayList<Integer>(),0);
        return result;
    }
    
    public void dfs(int[] nums,int target, List<List<Integer>> result,ArrayList<Integer> tmp,int idx){
       if(target == 0 ){
           result.add(new ArrayList<Integer>(tmp));
           return;
       }
       if(target < 0) return;
       for(int i = idx; i< nums.length; i++){
          tmp.add(nums[i]);
          dfs(nums, target-nums[i], result, tmp,i);
          tmp.remove(tmp.size()-1);
       }
    }
}
