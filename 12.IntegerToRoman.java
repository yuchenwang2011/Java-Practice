12. Integer to Roman My Submissions Question
Total Accepted: 58998 Total Submissions: 154979 Difficulty: Medium
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

Answer:
https://leetcode.com/problems/integer-to-roman/discuss/6310/My-java-solution-easy-to-understand
class Solution {
    public String intToRoman(int num) {
        String result = "";
        if(num <= 0 || num > 3999) return result;
        int[] nums = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] values = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    
        for(int i = 0; i < nums.length; i++){
            while(num >= nums[i]){
                num -= nums[i];
                result += values[i];
            }
        }
        return result;
    }
}

public class Solution {
    public String intToRoman(int num) {
        https://leetcode.com/problems/integer-to-roman/discuss/6274/Simple-Solution
        //I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
        if (num <=0 || num > 3999) return null;
        String[] M = new String[]{"","M","MM","MMM"};
        String[] C = new String[]{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] X = new String[]{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] I = new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
