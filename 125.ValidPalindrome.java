Given a string, determine if it is a palindrome, considering only alphanumeric characters 
and ignoring cases.
For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
Note:
Have you consider that the string might be empty? 
This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.

Answer:
public class Solution {
    public boolean isPalindrome(String s) {
        char[] data = s.toCharArray();
        int start = 0; int end = data.length-1;
        if(data.length == 0) {
            return true;
        } else {
           while(start < end) {
             while(start < end && Character.isLetterOrDigit(data[start]) == false){
                start++;
             }
             while(start < end && Character.isLetterOrDigit(data[end]) == false){
                end--;
             }
             if (start < end && Character.toLowerCase(data[start]) != Character.toLowerCase(data[end])) {  
                return false;
             }   
             start++;end--;
           }
        }
        return start >= end; //here it's totally ok to return true
    }
}
