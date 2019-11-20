5. Longest Palindromic Substring My Submissions QuestionEditorial Solution
Total Accepted: 102948 Total Submissions: 449006 Difficulty: Medium
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, 
and there exists one unique longest palindromic substring.

Answer:
//这个题必须掌握下面两种解法
//这个方法后面经常用到，为了防止记混，就记住一种方法就好了。132用同样的方法
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


class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        String result = "";
        for(int i = 0; i < s.length(); i++){
            String s1 = extendFromCenter(s, i, i);
            String s2 = extendFromCenter(s, i, i + 1);
            if(s1.length() > result.length()) result = s1;
            if(s2.length() > result.length()) result = s2; //如果s1 s2都大，刚才s1已经换过了result=s1了
        }
        return result;
    }
    
    public String extendFromCenter(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        //因为最终start和end那俩不配对，所以substring从start + 1开始，因为start不配
        //同时substring不要最后的那个end
        return s.substring(start + 1, end);
    }
}
