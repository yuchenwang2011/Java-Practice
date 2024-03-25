1249. Minimum Remove To Make Valid Parentheses
Given a string s of '(' , ')' and lowercase English characters.
Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) 
so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:
It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 
Example 1:
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
  
Example 2:
Input: s = "a)b(c)d"
Output: "ab(c)d"
  
Example 3:
Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 

Constraints:
1 <= s.length <= 105
s[i] is either'(' , ')', or lowercase English letter.
Accepted 589.1K Submissions 875.9K Acceptance Rate 67.3%

Answer:
//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/solutions/419402/java-c-stack/
class Solution {
    public String minRemoveToMakeValid(String s) {
        if(s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '('){
                stack.push(i);
            }
            if(sb.charAt(i) == ')'){
                if(!stack.isEmpty()) stack.pop();
                else sb.setCharAt(i, '*');
            }
        }
        
        while(!stack.isEmpty()){
            sb.setCharAt(stack.pop(), '*');
        }
        return sb.toString().replaceAll("\\*", "");
    }
}
