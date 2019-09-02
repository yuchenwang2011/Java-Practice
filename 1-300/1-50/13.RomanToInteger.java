13. Roman to Integer My Submissions Question
Total Accepted: 77084 Total Submissions: 199669 Difficulty: Easy
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Answer:
Solution
https://leetcode.com/problems/roman-to-integer/discuss/6529
/My-solution-for-this-question-but-I-don't-know-is-there-any-easier-way
    class Solution {
    public int romanToInt(String s) {
        long result = 0;
        
        if(s.indexOf("IV") != -1) result-=2;
        if(s.indexOf("IX") != -1) result-=2;
        if(s.indexOf("XL") != -1) result-=20;
        if(s.indexOf("XC") != -1) result-=20;
        if(s.indexOf("CD") != -1) result-=200;
        if(s.indexOf("CM") != -1) result-=200;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            switch(c){
                case 'I': 
                    result+=1;
                    break;
                case 'V':
                    result+=5;
                    break;
                case 'X':
                    result+=10;
                    break;
                case 'L':
                    result+=50;
                    break;
                case 'C':
                    result+=100;
                    break;
                case 'D':
                    result+=500;
                    break;
                case 'M':
                    result+=1000;
                    break;
                default:
                    break;    
            }
        }
        return (int) result;        
    }
}


class Solution {
    public  int romanToInt(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
            case 'I':
                res += (res >= 5 ? -1 : 1);
                break;
            case 'V':
                res += 5;
                break;
            case 'X':
                res += 10 * (res >= 50 ? -1 : 1);
                break;
            case 'L':
                res += 50;
                break;
            case 'C':
                res += 100 * (res >= 500 ? -1 : 1);
                break;
            case 'D':
                res += 500;
                break;
            case 'M':
                res += 1000;
                break;
            }
        }
        return res;
    }
}
