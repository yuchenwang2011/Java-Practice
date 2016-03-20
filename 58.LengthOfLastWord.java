
f Last Word My Submissions Question
Total Accepted: 86786 Total Submissions: 299441 Difficulty: Easy
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.

Answer:
//First one is my own answer, second one is most other people solve it
//**********Remember how to use trim and lastIndexOf, though you can also trim first then while loop

public class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        if(s == null || s.length() == 0) return count;
        int length = s.length()-1;
        for(int i = length; i >= 0; i--) {
            if(count == 0 && s.charAt(i) == ' ') continue;
            if(count != 0 && s.charAt(i) == ' ') break; 
            count++;
        }
        return count;
    }
}

public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        return s.trim().length() -1 - s.trim().lastIndexOf(' ');
    }
}
