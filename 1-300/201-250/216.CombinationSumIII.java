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
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if(k <= 0 || n <= 0) return result;
        helper(result, k, n, new ArrayList<Integer>(), 1);
        return result;
    }
    
    public void helper(List<List<Integer>> result, int k, int n, List<Integer> tmp, int idx){
        if(k == 0 && n == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        if(k <= 0 || n <= 0 || idx > 9) return;
        for(int i = idx; i <= 9; i++){
            tmp.add(i);
            helper(result, k - 1, n - i, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
