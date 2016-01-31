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

Answer: 
  public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      if(nums == null || nums.length ==0){
          return result;
      }
      Arrays.sort(nums);
      List<Integer> tmp = new ArrayList<Integer>();
      result.add(tmp);
      dfs(0,nums,tmp,result);
      return result;
    }
    
    public void dfs(int idx, int[] nums, List<Integer> tmp, List<List<Integer>> result){
        for(int i = idx; i < nums.length; i++){
            tmp.add(nums[i]);
            result.add(new ArrayList<Integer>(tmp));
            dfs(i+1, nums, tmp, result);
            tmp.remove(tmp.size()-1);
            //这个while是给大的for用的。一旦发现重复就跳过，他的责任完成了，下面的基层就不管了
            //用 1,1,2,2,3 手写来一遍。对于每一层来说，一旦有过一个数字，就不能再有一次了。
            //就得跳过去，但是第一次出现的时候嘛，那肯定是可以加的。
            while(i < nums.length -1 && nums[i+1] == nums[i]) i++;
            //remember that i < nums.length -1 must be put in front other wise out of boundary exception
        }
    }
}
