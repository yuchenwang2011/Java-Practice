216. Combination Sum III My Submissions Question
Total Accepted: 23640 Total Submissions: 69801 Difficulty: Medium
Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination 
should be a unique set of numbers.
Ensure that numbers within the set are sorted in ascending order.

Example 1:
Input: k = 3, n = 7
Output:
[[1,2,4]]

Example 2:
Input: k = 3, n = 9
Output:
[[1,2,6], [1,3,5], [2,3,4]]

Answer:
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int target) {
       List<List<Integer>> result = new ArrayList<List<Integer>>();
       if(k < 0 || k > 9 || target <0){
           return result;
       }
       List<Integer> tmp = new ArrayList<Integer>();
       dfs(k,target, result, tmp, 0);
       return result;
    }
    
    public void dfs(int k,int target,List<List<Integer>> result,List<Integer> tmp,int idx){
      if(target == 0 && tmp.size() == k){
          result.add(new ArrayList<Integer>(tmp));
          return;
      }   
      if(target < 0 || tmp.size() >= k) return;
      for(int i = idx; i < 9; i++){
          tmp.add(i+1);
          dfs(k,target-i-1,result,tmp,i+1);
          tmp.remove(tmp.size()-1);
      }
    }
}
