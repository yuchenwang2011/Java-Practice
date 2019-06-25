242. Valid Anagram My Submissions Question
Total Accepted: 50365 Total Submissions: 126225 Difficulty: Easy
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

Answer:
import java.util.*;
public class Solution {
    //You can finish the quesiton by both char[] array or HashMap
    //Of course this question asks you to use HashMap as Unicode needs 10,000 elements
    //And always remember, when answer, the first thing to do is to check null or length 0
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
        return false;
        }
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        HashMap<Character, Integer> myHash = new HashMap<Character,Integer>();
        //First round to count the frequency and save into HashMap
        for(int i = 0; i < arr1.length; i++) {
            if(myHash.get(arr1[i])!=null){//it means this letter has appeared before
                myHash.put(arr1[i],myHash.get(arr1[i])+1);
            } else {
                myHash.put(arr1[i],1); //it means this is the first time the letter appears
            }
        }
        //Second round to compare if the frequency the same and if it doen't even have this letter
        for(int i=0; i< arr2.length; i++) {
            if(myHash.get(arr2[i]) == null || myHash.get(arr2[i]) == 0){ //it means this letter never appears before
                return false;
            } else {
                myHash.put(arr2[i],myHash.get(arr2[i])-1);
            }
            
        }
        return true;
    }
}
