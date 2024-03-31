680. Valid Palindrome II Easy
Given a string s, return true if the s can be palindrome after deleting at most one character from it.
Example 1:
Input: s = "aba"
Output: true
  
Example 2:
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
  
Example 3:
Input: s = "abc"
Output: false
 
Constraints:
1 <= s.length <= 105
s consists of lowercase English letters.

Accepted 720.7K Submissions 1.8M Acceptance Rate 40.5%

Answer:
//https://leetcode.com/problems/valid-palindrome-ii/solutions/209252/java-python-two-pointers-with-thinking-process/
class Solution {
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)){
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            } 
            i++; j--;
        }
        return true;
    }

    public boolean isPalindrome(String s, int i, int j){
        if(s == null || s.length() ==0 ) return true;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}
