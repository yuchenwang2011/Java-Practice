22. Generate Parentheses My Submissions Question
Total Accepted: 82350 Total Submissions: 226433 Difficulty: Medium
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

Answer:
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n <= 0) return result;
        helper(n, result, 0, 0, "");
        return result;
    }
    
    public void helper(int n, List<String> result, int left, int right, String tmp){
        if(left == n && right == n) {
            result.add(tmp);
            return;
        }
        if(left > n || right > n || right > left) return;
        helper(n, result, left + 1, right, tmp + "(");
        helper(n, result, left, right + 1, tmp + ")");
    }
}
