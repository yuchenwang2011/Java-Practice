150. Evaluate Reverse Polish Notation   My Submissions QuestionEditorial Solution
Total Accepted: 63513 Total Submissions: 270126 Difficulty: Medium
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
  
Answer:
public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for(int i = 0; i < tokens.length; i++){
            String s = tokens[i];
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int oper2 = stack.pop();
                int oper1 = stack.pop();
                if(s.equals("+")) stack.push(oper1 + oper2);
                if(s.equals("-")) stack.push(oper1 - oper2);
                if(s.equals("*")) stack.push(oper1 * oper2);
                if(s.equals("/")) stack.push(oper1 / oper2);
            } else {
                int oper = Integer.valueOf(s);
                stack.push(oper);
            }
        }
        return stack.peek();
    }
}
