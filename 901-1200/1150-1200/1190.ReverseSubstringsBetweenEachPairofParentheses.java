1190. Reverse Substrings Between Each Pair of Parentheses  Medium

Given a string s that consists of lower case English letters and brackets. 
Reverse the strings in each pair of matching parentheses, starting from the innermost one.
Your result should not contain any bracket.

Example 1:
Input: s = "(abcd)"
Output: "dcba"

Example 2:
Input: s = "(u(love)i)"
Output: "iloveu"

Example 3:
Input: s = "(ed(et(oc))el)"
Output: "leetcode"

Example 4:
Input: s = "a(bcdefghijkl(mno)p)q"
Output: "apmnolkjihgfedcbq"
 
Constraints:
0 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It's guaranteed that all parentheses are balanced.
Accepted 2,338  Submissions 4,409

Answer:
//my own answer at contest 154
class Solution {
    public String reverseParentheses(String s) {
        String tmp = "";
        if(s == null || s.length() == 0) return tmp;

        Stack<String> stack = new Stack<>();
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(tmp);
                tmp = "";
            } else if (c == ')') {
                tmp = stack.pop() + reverse(tmp);
            } else {
                tmp += c;
            }
            i++;
        }
        return tmp;
    }
    
    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        return sb.reverse().toString();
    }
}
