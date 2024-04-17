1071. Greatest Common Divisor of Strings
Easy 4.2K 808

For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Example 1:
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Example 2:
Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"

Example 3:
Input: str1 = "LEET", str2 = "CODE"
Output: ""
 
Constraints:
1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase letters.
Accepted 241.5K Submissions 456.5K Acceptance Rate 52.9%

Answer:
//https://leetcode.com/problems/greatest-common-divisor-of-strings/solutions/516621/java-clean-solution-0-ms-100/
//辗转相除法
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)) return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public int gcd(int p, int q){
        if(q == 0) return p;
        return gcd(q, p % q);
    }
}
