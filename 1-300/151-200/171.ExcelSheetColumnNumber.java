171. Excel Sheet Column Number My Submissions QuestionEditorial Solution
Total Accepted: 73230 Total Submissions: 177882 Difficulty: Easy
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    
Answer:
public class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) return 0;
        long sum = 0;
        for(int i = 0 ; i < s.length() ; i++){
            sum *= 26;
            sum += s.charAt(i) - 'A' + 1;
        }
        return (sum > Integer.MAX_VALUE)? Integer.MAX_VALUE : (int)sum;
    }
}

class Solution {
    public int titleToNumber(String s) {
        long result = 0;
        if(s == null || s.length() == 0) return (int) result;
        
        int digit = 0;
        while(s.length() != 0){
            char c = s.charAt(s.length() - 1);
            result += (c - 'A' + 1) * Math.pow(26, digit);
            digit++;
            s = s.substring(0,s.length() - 1);
        }
        
        return result > Integer.MAX_VALUE? Integer.MAX_VALUE : (int) result;
    }
}
