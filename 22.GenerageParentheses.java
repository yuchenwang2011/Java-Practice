22. Generate Parentheses My Submissions Question
Total Accepted: 82350 Total Submissions: 226433 Difficulty: Medium
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

Answer:
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if(n == 0) {
            result.add("");
            return result;
        }
        process(n,result,"",0,0);
        return result;
    }
    public void process(int n, List<String> result, String tmp, int left, int right){
        if(left == right && left == n) {
            result.add(tmp);
            return;
        }
        if(left > n || right > left) return;
        process(n,result, tmp + "(", left+1, right);
        process(n,result, tmp + ")", left, right+1);
    }
}
