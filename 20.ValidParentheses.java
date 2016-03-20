20. Valid Parentheses My Submissions Question
Total Accepted: 99456 Total Submissions: 343191 Difficulty: Easy
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

The brackets must close in the correct order, 
"()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Answer"
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
        return stack.isEmpty()? true : false;
    }
}
//Test Case: "()",()[{}]", "()[{]}","{([])}","}}(]}}){)(])](}{{}[]","]]{}"
