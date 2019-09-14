58. Length of Last Word . Easy
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
return the length of last word in the string.

If the last word does not exist, return 0.
Note: A word is defined as a character sequence consists of non-space characters only.

Example:
Input: "Hello World"
Output: 5

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

//Second round other people's answer
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        return s.trim().length() -1 - s.trim().lastIndexOf(' ');
    }
}

//Third round my own answer at Oct6, 2017
class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.trim().replace("\\s+", " ");
        String[] array = s.split(" ");
        return array[array.length - 1].length();
    }
}
