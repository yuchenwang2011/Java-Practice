29. Divide Two Integers My Submissions QuestionEditorial Solution
Total Accepted: 63709 Total Submissions: 408002 Difficulty: Medium
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.

Answer:
public class Solution {
    //Got inspired by this answer, it is probably the most clear answer
    //http://simpleandstupid.com/2014/10/21/divide-two-integers-leetcode-%E8%A7%A3%E9%A2%98%E7%AC%94%E8%AE%B0/
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        if(dividend == 0 || divisor == 1) return dividend;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long result = 0;
        
        while(a >= b) {
            long c = b;
            int i = 0;
            
            while(a >= c){
                a = a - c;
                c = c << 1;
                result = result + (1 << i); //count how many chunk of b has been subtracted, 0,1 ; 1,2
                i ++;
            }
        }
        if( (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ) result = -result;
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }
}
