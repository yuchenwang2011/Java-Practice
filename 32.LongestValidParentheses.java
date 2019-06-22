32. Longest Valid Parentheses
Hard
Given a string containing just the characters '(' and ')', find the length 
of the longest valid (well-formed) parentheses substring.
Example 1:
Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"

Example 2:
Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"

(()) is 4, (()()) is 6, 

Solution:
//这个题的意思是string里只有括号的符号，没乱七八糟的其他东西。First read through this video
//Try go through those examples using the method on paper, you will understand this method.
//1. "("  2. ")"   3. "(("  4. "))"  5. "))("   6. "))()"    7. "()"
//8. "))(()"   9. "))(())"    10. "())"     11. "(()(())"    12. "(()(()("     13. "(()())"
https://www.youtube.com/watch?v=AqnGU4RjrxY
class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() < 1) return 0;
        int result = 0;
        int start = -1;
        
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            } else {
                if(stack.isEmpty()){
                    start = i;
                } else {
                    stack.pop();
                    if(stack.isEmpty()){
                        result = Math.max(result, i - start);
                    } else {
                        result = Math.max(result, i - stack.peek());
                    }
                }
            }
        }
        return result;
    }
}
