90. Subsets II My Submissions Question
Total Accepted: 58978 Total Submissions: 199504 Difficulty: Medium
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

//May22 2019：统一按这种模板来处理重复
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        helper(nums, result, new ArrayList<Integer>(), 0);
        
        return result;
    }
    
    public void helper(int[] nums, List<List<Integer>> result, List<Integer> tmp, int idx){
        result.add(new ArrayList<>(tmp));
        for(int i = idx; i < nums.length; i++){
        *******************************************
            if(i > idx && nums[i - 1] == nums[i]) continue;
        *******************************************     
            tmp.add(nums[i]);
            helper(nums, result, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
