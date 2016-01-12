3. Longest Substring Without Repeating Characters My Submissions Question
Total Accepted: 118315 Total Submissions: 559065 Difficulty: Medium
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
For "bbbbb" the longest substring is "b", with the length of 1.

Answer:
import java.util.*;
public class Solution {
    //*****charAt is ()!!!!!!
    //I got inspired by this answer: https://leetcode.com/discuss/27201/share-my-java-solution
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int start =0; int end = 0; int maxLength = 0;
        HashMap<Character, Integer> myHash = new HashMap<Character,Integer>();
        for(;end < s.length();end++) {
            if(myHash.containsKey(s.charAt(end))){
                //this is for example baacdebxp, the second b gives the location before the start, which is the second a now  
               start = Math.max(start, myHash.get(s.charAt(end))+1);
            }
            myHash.put(s.charAt(end),end);
            maxLength = Math.max(maxLength, end-start+1);
        }
        return maxLength;
    }
}
