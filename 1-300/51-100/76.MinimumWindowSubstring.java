76. Minimum Window Substring
Hard

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
Example:
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:
If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

Hint1: Use two pointers to create a window of letters in S, which would have all the characters from T.

Hint2: Since you have to find the minimum window in S which has all the characters from T, 
you need to expand and contract the window using the two pointers and keep checking the window for all the characters. 
This approach is also called Sliding Window Approach. 

L ------------------------ R , Suppose this is the window that contains all characters of T              
        L----------------- R , this is the contracted window. 
We found a smaller window that still contains all the characters in T
When the window is no longer valid, start expanding again using the right pointer. 

Answer:
//all solutions are from discussions from this amazing template
// https://leetcode.com/problems/minimum-window-substring/discuss/
//  26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
//on page 9 of dicussion, someone translates the template into java
//this video is made to explain it: https://www.youtube.com/watch?v=9odu9ImG9oY&t=694s
//also this video: https://www.youtube.com/watch?v=eS6PZLjoaq8

//in total there are 3 steps
//1. Use two pointers: start and end to represent a window.
//2. Move end to find a valid window.
//3. When a valid window is found, move start to find a smaller window.
//To check if a window is valid, we use a map to store (char, count) for chars in t. 
//And use counter for the number of chars of t to be found in s. The key part is m[s[end]]--;. 
//We decrease count for each char in s. If it does not exist in t, the count will be negative.

class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        if(s == null || s.length() == 0 || t == null || t.length() == 0) return result;
        
        int[] map = new int[256];
        //注意这里是t
        for(int i = 0; i < t.length(); i++){
            map[t.charAt(i)]++;
        }
        
        int start = 0;
        int end = 0;
        int count = t.length();
        int max = Integer.MAX_VALUE;
        
        while(end < s.length()){
            if(map[s.charAt(end++)]-- > 0) {
                count--;
            }
            while(count == 0) {
                if(end - start < max) {
                    max = end - start;
                    result = s.substring(start, end);
                }
                if(map[s.charAt(start++)]++ == 0) {
                    count++;
                }
            }
        }
        return result;
    }
}
