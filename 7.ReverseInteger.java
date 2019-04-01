7. Reverse Integer My Submissions QuestionEditorial Solution
Total Accepted: 131913 Total Submissions: 558239 Difficulty: Easy
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Answer:
public class Solution {
    public int reverse(int x) {
        long y = 0;
        while(x != 0){
            y = y * 10 + x % 10;
            x = x / 10;
        }
        
        if( y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) return 0;
        return (int) y;
    }
}

Answer2:
https://leetcode.com/problems/reverse-integer/discuss/4060/My-accepted-15-lines-of-code-for-Java
while(){
  newResult = result * 10  + x % 10;
  if( (newResult - x % 10) / 10 != result) return 0;
}
