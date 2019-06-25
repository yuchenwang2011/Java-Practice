227. Basic Calculator II My Submissions Question
Total Accepted: 19443 Total Submissions: 79940 Difficulty: Medium
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.

Answer:
public class Solution {
    //Got inspired by this answer:
    //https://leetcode.com/discuss/41902/share-my-java-solution
    //Test case: 12*3-56+7/8, the whole loop is as follows:
    //sign=+,i=0,num=1;
    //sign=+,i=1,num=12;
    //sign=+,i=2,num=12,stack.put(+12),sign=*,num=0;
    //sign=*,i=3,num=3;
    //sign=*,i=4,num=34;
    //sign=*,i=5,num=34,stack.put(12*34),sign=-,num=0
    //sign=-,i=6,num=5;
    //sign=-,i=7,num=56;
    //sign=-,i=8,num=56,stack.put(-56),sign=+,num=0;
    //sign=+,i=9,num=7;
    //sign=+,i=10,num=7,stack,put(+7),sign=/,num=0;
    //sign=/,i=len-1=11,num=8,stack,put(7/8),sign=8,
    public int calculate(String s) {
        int result = 0;
        if(s == null || s.length() == 0) return result;
        s = s.trim().replaceAll("\\s+","");
        int num = 0 ;
        char sign = '+';
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            //whenever find a sign, put num into stack, then update the sign and num
            //at end of string, no more new sign behind, so you have to put num into stack
            if(Character.isDigit(c) == false || i == s.length()-1){
                if(sign == '+') stack.push(num);
                if(sign == '-') stack.push(-num);
                if(sign == '*') stack.push(stack.pop()*num);
                if(sign == '/') stack.push(stack.pop()/num);
                //update sign and num for next round;
                sign = c;
                num = 0;
            }
        }
        for(int i : stack){
            result += i;
        }
        return result;
    }
}
