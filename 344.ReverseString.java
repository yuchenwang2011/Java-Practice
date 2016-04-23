344. Reverse String   My Submissions QuestionEditorial Solution
Total Accepted: 2919 Total Submissions: 4867 Difficulty: Easy
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

Answer:
public class Solution {
    public String reverseString(String s) {
        if(s == null || s.length() == 0) return "";
        char[] c = s.toCharArray();
        int start = 0, end = c.length-1;
        while(start <= end){
            char tmp = c[start];
            c[start] = c[end];
            c[end] = tmp;
            start ++;
            end --;
        }
        return new String(c);
    }
}
