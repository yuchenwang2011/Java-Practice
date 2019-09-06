29. Divide Two Integers My Submissions QuestionEditorial Solution
Total Accepted: 63709 Total Submissions: 408002 Difficulty: Medium
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.

Answer:
public class Solution {
    //Got inspired by this answer, it is probably the most clear answer
    //http://simpleandstupid.com/2014/10/21/divide-two-integers-leetcode-%E8%A7%A3%E9%A2%98%E7%AC%94%E8%AE%B0/
    //这个就相当于先扣一块divisor，发现哎呀还剩挺多，干脆divisor * 2， 一次扣两块。一次扣4块，如此一来就变成1+2+4最后扣了7块。
    //然后发现4块有点多了，不够，可能现在就剩3块了。所以重新来，又从1块，2块开始扣起
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        if(dividend == 0 || divisor == 1) return dividend;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long result = 0;
        
        while(a >= b) {
            long c = b;
            int digit = 0;
            
            while(a >= c){
                a = a - c;
                c = c << 1;
                result = result + (1 << digit); //count how many chunk of b has been subtracted, 0,1 ; 1,2
                digit++;
            }
        }
        if( (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ) result = -result;
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }
}
