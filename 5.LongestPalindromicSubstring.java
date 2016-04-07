5. Longest Palindromic Substring My Submissions QuestionEditorial Solution
Total Accepted: 102948 Total Submissions: 449006 Difficulty: Medium
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, 
and there exists one unique longest palindromic substring.

Answer:
public class Solution {
    //First answer is dynamic programming
    public String longestPalindrome(String s) {
        //This indian video is very good, it's very fast, but after you read the code carefully, you will understand
        //https://www.youtube.com/watch?v=obBdxeCx_Qs
        //https://github.com/IDeserve/learn/blob/master/LongestPalindromicSubstring.java
        if(s == null || s.length() == 0) return "0";
        int maxStart = 0; int maxLength = 1;
        boolean[][] result = new boolean[s.length()][s.length()]; //all the elements are false initially
        
        //First finish the single letter string, they are all palindromes
        for(int i = 0; i < s.length(); i++){
            result[i][i] = true;
        }
        //Second finish the two-letter string, they can't use loop to determine, so we need to do it separately
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)) {
                result[i][i+1] = true;
                maxStart = i;
                maxLength = 2;
            }
        }
        //Third finish length from 3 to N, they can use loop to compare from start end to center
        for(int length = 3; length <= s.length(); length++){
            for(int start = 0; start < s.length()-length+1; start++){
                //because end = start + len - 1 < s.length() ==> start + len -1 < length ==> start < length - len +1
                int end = start + length -1;  //Here you just want to compare once, not recursively, so end is the other side
                if(s.charAt(start) == s.charAt(end) && result[start+1][end-1] == true) {
                    //It's kinda recursively check if its true, must inner string is true and outside 2 value are equal
                    result[start][end] = true;
                    maxLength = length;
                    maxStart = start;
                }
            }
        }
        return s.substring(maxStart, maxStart + maxLength);
    }
}
