20. Valid Parentheses My Submissions Question
Total Accepted: 99456 Total Submissions: 343191 Difficulty: Easy
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

The brackets must close in the correct order, 
"()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Answer
//我自己会精神状态不稳定，不一定会写出来下面哪个答案。随机的看不懂另外一个，别删
public class Solution {
    //There seems to be a few good answers, but I don't understand them. I will check them again next round;
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        if(s.length() % 2 == 1) return false;
        for (int i = 0; i < s.length(); i++){
           if(!stack.isEmpty()){
               char a = stack.peek();
               char b = s.charAt(i);
               if(a == '(' && b == ')' || a == '[' && b ==']' || a=='{' && b == '}') {
                   stack.pop();
                   continue;
               }
           }
           stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }
}

class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        if(s.length() % 2 == 1) return false;
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                if(c == '(') stack.push(')');
                if(c == '{') stack.push('}');
                if(c == '[') stack.push(']');
            } else if (!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            } else {
                return false;
            }            
        }
        return stack.isEmpty();
    }
}
