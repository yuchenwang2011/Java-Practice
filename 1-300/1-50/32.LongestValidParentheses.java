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
        //start的意义就是合理的括号的起点，就是意思是我本身不是valid的，我右边的那些都是valid
        int start = -1;
        
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                //就是说我i右边的都是合理的，我本身并不是一个合理的，non-inclusive
                //如果你要把我这里的左括号当做合理的值，你需要找start或者我前一个括号，反正就是我左边的那个值，来计算我
                stack.push(i);
            } else {
                //这里好理解，就是如果啥都没有，你这里还是结尾的括号，不合理啊，所以valid的开始要从你这里开始啊
                if(stack.isEmpty()){
                    start = i;
                } else {
                    //这里是后括号和前括号抵消了，然后result的计算不是只有这一对啊，要看看更以前start那个合理的括号起点
                    stack.pop();
                    if(stack.isEmpty()){
                        //如果stack啥都没有了，意味着你只能和之前的那个start相减来获得长度了
                        //而且start是non-inclusive的，不用加1
                        //")()())"
                        result = Math.max(result, i - start);
                    } else {
                        //说明你的后括号还没有能力完全抵消掉所有stack里的前括号，也就还不配用start这个起始点
                        //你只能到上一个peek那里为止了。
                        //"(()"
                        result = Math.max(result, i - stack.peek());
                    }
                }
            }
        }
        return result;
    }
}

//这个版本就是所有的都得+1的版本，方法和上面的一样的
class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;
        if(s == null || s.length() == 0) return result;
        
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int start = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i + 1);
            } else {
                if(stack.size() == 0) start = i + 1;
                else {
                    stack.pop();
                    if(stack.isEmpty()) {
                        result = Math.max(result, i - start + 1);
                    } else {
                        result  = Math.max(result, i - stack.peek() + 1);
                    }
                }
            }
            i++;
        }
        
        return result;
    }
}
