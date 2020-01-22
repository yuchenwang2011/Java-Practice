345. Reverse Vowels of a String
Easy

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Input: "hello"
Output: "holle"

Example 2:
Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".

Accepted 189,571 Submissions 442,205

Answer:
class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
        String vows = "aeiouAEIOU";
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            while(start < end && vows.indexOf(chars[start]) == -1) start++;
            while(start < end && vows.indexOf(chars[end]) == -1) end--;

            char tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
        return new String(chars);
    }
}
