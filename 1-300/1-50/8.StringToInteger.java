8. String to Integer (atoi) My Submissions Question
Total Accepted: 82463 Total Submissions: 625661 Difficulty: Easy
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Answer: 
class Solution {
    public int myAtoi(String s) {
        long result = 0;
        if(s == null || s.length() == 0) return (int)result;

        s = s.trim();

        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            int tmp = s.charAt(i) - '0';
            if(i == 0 && s.charAt(i) == '+') sign = 1;
            else if(i == 0 && s.charAt(i) == '-') sign = -1;
            else {
                if(tmp < 0 || tmp > 9) break;
                result = result * 10 + tmp;
            }

            if(sign > 0 && sign * result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign < 0 && sign * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int)result * sign;
    }
}
