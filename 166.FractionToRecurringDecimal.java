166. Fraction to Recurring Decimal My Submissions QuestionEditorial Solution
Total Accepted: 28610 Total Submissions: 191714 Difficulty: Medium
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
Hint:

No scary math, just apply elementary math knowledge. Still remember how to perform a long division?
Try a long division on 4/9, the repeating part is obvious. Now try 4/333. Do you see a pattern?
Be wary of edge cases! List out as many test cases as you can think of and test your code thoroughly.

Answer:
public class Solution {
    //I don't have any idea about this question. List some popular answers in discuss
    //Knowledge here: recurring decimal can be represented by fraction number
    //https://leetcode.com/discuss/50512/accepted-clean-java-solution
    //https://leetcode.com/discuss/31521/short-java-solution
    //https://leetcode.com/discuss/23079/my-clean-java-solution
    //https://leetcode.com/discuss/18731/accepted-cpp-solution-with-explainations
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        if(denominator == 0) return "";
        if(numerator == 0) return "0";
        String sign = (numerator > 0 && denominator > 0  || numerator < 0 && denominator <0 ) ? "" : "-"; 
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        result.append(sign);
        result.append(num/den);
        System.out.println(num/den);
        long remainder = num % den;
        if(remainder == 0) return result.toString();
        result.append(".");
        
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while(!map.containsKey(remainder) && remainder != 0){
            map.put(remainder, result.length());
            result.append(10 * remainder / den);
            remainder = 10 * remainder % den;
        }
        if(remainder == 0) return result.toString();
        
        int index = map.get(remainder);
        result.insert(index, "(");
        result.append(")");
        return result.toString().replace("(0)",""); //for case 1/ 5 = 0.2(0)
    }
}
