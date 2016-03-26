151. Reverse Words in a String My Submissions Question
Total Accepted: 95637 Total Submissions: 610939 Difficulty: Medium
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.

Answer:
//My first answer is silly, because I used the way when dealing with int arrays
//But this is a string, so just do it in the method of second one
public class Solution {
    public String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+"," ");
        if(s == null || s.length() == 0) return "";
        String[] tmp = s.split("\\s");
        String result = revert(tmp[0]);
        for(int i = 1; i < tmp.length; i++){
            result = result + " " + revert(tmp[i]);
        }
        return revert(result);
    }
    public String revert(String str){
        char[] c = str.toCharArray();
        int start = 0, end = c.length-1;
        while(start < end){
            char tmp = c[start];
            c[start] = c[end];
            c[end] = tmp;
            start ++; end--;
        }
        return new String(c);
    }
}

public class Solution {
    public String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+"," ");
        if(s == null || s.length() == 0) return s;
        String[] tmp = s.split("\\s");
        String result = "";
        for(int i = tmp.length-1; i >=1; i--) {
            result = result + tmp[i] + " ";
        }
        result += tmp[0];
        return result;
    }
}
