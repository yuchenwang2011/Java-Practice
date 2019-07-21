214. Shortest Palindrome
Hard

Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. 
Find and return the shortest palindrome you can find by performing this transformation.

Example 1:
Input: "aacecaaa"
Output: "aaacecaaa"

Example 2:
Input: "abcd"
Output: "dcbabcd"

Answer:
class Solution {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        
        int start = 0;
        int endBackUp = s.length() - 1;
        int end = endBackUp;
        while(start < end){
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                //means last round, start to last end doesn't work
                //so startover and try test one letter before end of string
                start = 0;
                endBackUp--;
                end = endBackUp;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        return sb.append(s.substring(endBackUp + 1)).reverse().append(s).toString();
    }
}
