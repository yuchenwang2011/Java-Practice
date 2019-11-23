13. Roman to Integer My Submissions Question
Total Accepted: 77084 Total Submissions: 199669 Difficulty: Easy
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. 
    Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. 
However, the numeral for four is not IIII. Instead, the number four is written as IV. 
Because the one is before the five we subtract it making four. 
The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:
Input: "III"
Output: 3
    
Example 2:
Input: "IV"
Output: 4
    
Example 3:
Input: "IX"
Output: 9
    
Example 4:
Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
    
Example 5:
Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

Answer:
class Solution {
    public int romanToInt(String s) {
        int result = 0;
        if(s == null || s.length() == 0) return result;
        
        if(s.indexOf("IV") >= 0 || s.indexOf("IX") >= 0) result -= 2;
        if(s.indexOf("XL") >= 0 || s.indexOf("XC") >= 0) result -= 20;
        if(s.indexOf("CD") >= 0 || s.indexOf("CM") >= 0) result -= 200;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'I') result += 1;
            if(c == 'V') result += 5;
            if(c == 'X') result += 10;
            if(c == 'L') result += 50;
            if(c == 'C') result += 100;
            if(c == 'D') result += 500;
            if(c == 'M') result += 1000;
        }
        return result;
    }
}

class Solution {
    public int romanToInt(String s) {
        int result = 0;
        if(s == null || s.length() == 0) return result;
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if(c == 'I') result += result >= 5 ? -1 : 1;
            if(c == 'V') result += 5;
            if(c == 'X') result += result >= 50 ? -10 : 10;
            if(c == 'L') result += 50;
            if(c == 'C') result += result >= 500 ? -100 : 100;
            if(c == 'D') result += 500;
            if(c == 'M') result += 1000;
        }     
        return result;
    }
}
