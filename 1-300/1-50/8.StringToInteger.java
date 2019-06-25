8. String to Integer (atoi) My Submissions Question
Total Accepted: 82463 Total Submissions: 625661 Difficulty: Easy
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Answer: 
class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        str = str.trim();
        if(str.length() == 0) return 0;
        int sign = 1;
        int start = 0;
        if(str.charAt(0) == '-'){
            sign = -1 ;
            start = 1;
        } else if(str.charAt(0) == '+'){
            sign = 1;
            start = 1;
        }
        
        long result = 0;
        
        for(int i = start; i < str.length(); i++){
            int tmp = str.charAt(i) - '0';
            if(tmp < 0 || tmp > 9) break;
            
            result = result * 10 + tmp;
            if(sign * result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        
        return (int) result * sign;
    }
}
