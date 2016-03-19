12. Integer to Roman My Submissions Question
Total Accepted: 58998 Total Submissions: 154979 Difficulty: Medium
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

Answer:
public class Solution {
    //I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
    public String intToRoman(int num) {
        if(num <= 0 || num > 3999) return null;
        String result = "";
        int digit = 0;
        while(num != 0){
            int value = num%10;
            digit++;
            if(value >=1 && value <=3){
                if(digit == 1)       result = addString(value, result, "I");
                else if (digit == 2) result = addString(value, result, "X");
                else if (digit == 3) result = addString(value, result, "C");
                else                result = addString(value, result, "M");
            }
            if(value == 4){
                if(digit == 1)       result = "IV" + result;
                else if (digit == 2) result = "XL" + result;
                else                result = "CD" + result;
            }
            if(value == 5){
                if(digit == 1)       result = "V" + result;
                else if (digit == 2) result = "L" + result;
                else                result = "D" + result;
            }
            if(value >=6 && value <=8){
                if(digit == 1)       result = "V" + addString(value%5, result, "I");
                else if (digit == 2) result = "L" + addString(value%5, result, "X");
                else                result = "D" + addString(value%5, result, "C");
            }
            if(value == 9){
                if(digit == 1)       result = "IX" + result;
                else if (digit == 2) result = "XC" + result;
                else                 result = "CM" + result;
            }
            num = num/10;
        }
        return result;
    }
    
    public String addString(int value, String result, String letter){
        for(int i = 0; i < value; i++) {
            result = letter + result;
        }
        return result;
    }
}
