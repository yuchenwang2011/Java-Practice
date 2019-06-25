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

===============================
//I feel above solution a little bit hard to understand, try to understand the second, then you can understand first
//https://leetcode.com/problems/generate-parentheses/discuss/10100/Easy-to-understand-Java-backtracking-solution
    class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n <= 0) return result;
        process(0,0,"",result,n);
        return result;
    }
    
    public void process(int left, int right, String tmp, List<String> result, int n){
        if(left >= n && left == right) {
            result.add(tmp);
        }
        if(left < n) {
            process(left + 1, right, tmp + "(", result, n);
        }
        if(right < left) {
            process(left, right + 1, tmp + ")", result, n);   
        }
    }
}
