77. Combinations   My Submissions QuestionEditorial Solution
Total Accepted: 73173 Total Submissions: 213980 Difficulty: Medium
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

Answer:
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n <= 0 || k <= 0 || k > n) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        List<Integer> tmp = new ArrayList<Integer>();
        process(n, k, result, tmp, 1);
        return result;
    }
    
    public void process(int n, int k, List<List<Integer>> result, List<Integer> tmp, int idx){
        if(k == 0) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for(int i = idx; i <= n; i++){
            tmp.add(i);
            process(n, k - 1 , result, tmp, i + 1);
            tmp.remove(tmp.size() -1 );
        }
    }
    
}
