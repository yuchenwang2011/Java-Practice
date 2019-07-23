224. Basic Calculator
Hard


Implement a basic calculator to evaluate a simple expression string.
The expression string may contain open ( and closing parentheses ), 
the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:
Input: "1 + 1"
Output: 2

Example 2:
Input: " 2-1 + 2 "
Output: 3

Example 3:
Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23

Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.

Answer:
class Solution {
    //https://leetcode.com/problems/basic-calculator/discuss/62361/Iterative-Java-solution-with-stack
    public int calculate(String s) {
        int result = 0;
        if(s == null || s.length() == 0) return result;
        
        int number = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                number = number * 10 + c - '0';
            } else if (c == '+'){
                result += number * sign;
                sign = 1;
                number = 0;
            } else if (c == '-'){
                result += number * sign;
                sign = -1;
                number = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
                //not really necessary because number should always been zero if it's a valid string
                number = 0;
            } else if (c == ')') {
                result += number * sign;
                result = result * stack.pop() + stack.pop();
                sign = 1;
                //not really necessary because number should always been zero if it's a valid string
                number = 0;
            }
        }
        if(number != 0) result += number * sign;
        
        return result;
    }
}
