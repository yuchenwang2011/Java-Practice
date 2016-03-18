13. Roman to Integer My Submissions Question
Total Accepted: 77084 Total Submissions: 199669 Difficulty: Easy
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Answer:
public class Solution {
    //Mine is also OK. 
    //The first answer is very good. Second one is also interesting, but I don't think we encourage it. 
    //https://leetcode.com/discuss/42582/my-java-solution
    //https://leetcode.com/discuss/2369/solution-for-this-question-but-dont-know-there-any-easier-way
    //I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
    public int romanToInt(String s) {
        int count = 0;
        if(s == null || s.length() == 0) return count;
        
        for(int i = s.length()-1; i >= 0; i--){
            char letter = s.charAt(i);
            
            if(letter == 'I') count += 1;
            
            if(letter == 'V') {
                if (i >= 1 && s.charAt(i-1) == 'I') { count += 4;i--; }
                else count += 5;
            }
            
            if(letter == 'X') {
                if(i >= 1 && s.charAt(i-1) == 'I') {count += 9; i--;}
                else count += 10;
            }
            
            if(letter == 'L') {
                if(i >= 1 && s.charAt(i-1) == 'X') {count += 40; i--;}
                else count += 50;
            }
            
            if(letter == 'C') {
                if(i >=1 && s.charAt(i-1) == 'X') {count += 90; i--;}
                else count += 100;
            }
            
            if(letter == 'D') {
                if(i >=1 && s.charAt(i-1) == 'C') {count += 400; i--;}
                else count += 500;
            }
            
            if(letter == 'M') {
                if(i >=1 && s.charAt(i-1) == 'C') {count += 900; i--;}
                else count += 1000;
            }
        }
        return count;
    }
}
