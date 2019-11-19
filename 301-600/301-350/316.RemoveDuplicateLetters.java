316. Remove Duplicate Letters
Hard

Given a string which contains only lowercase letters, 
remove duplicate letters so that every letter appears once and only once. 
You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:
Input: "bcabc"
Output: "abc"

Example 2:
Input: "cbacdcbc"
Output: "acdb"

Accepted 65,568 Submissions 194,269

Answer:
class Solution {
    //bcabc -> abc
    //abcbc -> abc
    //abcca -> abc
    //dcbec -> dbec
    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0) return s;
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        
        int pos = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) < s.charAt(pos)) pos = i;
            if(--count[s.charAt(i) - 'a'] == 0) break; 
        }
        String newString = s.substring(pos + 1).replaceAll("" + s.charAt(pos), "");
        return s.charAt(pos) + removeDuplicateLetters(newString);
    }
}
