8. String to Integer (atoi) My Submissions Question
Total Accepted: 82463 Total Submissions: 625661 Difficulty: Easy
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Answer: 
public class Solution {
    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        long result = 0; int tmp; int start = 0;int sign =1;

        str = str.trim();
        if(str.charAt(start) == '+') {
          sign = 1;start++;
        } else if (str.charAt(0) == '-') {
          sign = -1;start++;
        }
          for (int i = start; i< str.length();i++) {
            tmp = str.charAt(i) - '0';
            if (tmp < 0 || tmp > 9) {
                break;
            } else {
              result = result * 10 + tmp; 
              if (sign ==1 && result > Integer.MAX_VALUE) {return Integer.MAX_VALUE;}
              if (sign ==-1 && sign * result < Integer.MIN_VALUE) {return Integer.MIN_VALUE;}
            }
          }
          
        return (int) result * sign;
    }
}
