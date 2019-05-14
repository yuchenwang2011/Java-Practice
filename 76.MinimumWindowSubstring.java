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
        int[] map = new int[128];
        int res = Integer.MAX_VALUE, left = 0, right = 0, begin = 0, counter = t.length();
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i) - 'A']++;
        }
        while (right < s.length()) {
            if (map[s.charAt(right++) - 'A']-- > 0) counter--;  //这个数应该出现的次数减一
            while (counter == 0) {  //缩短左边界
                if (right - left < res) {
                    res = right - left;
                    begin = left;
                }
                if (map[s.charAt(left++) - 'A']++ == 0) counter++;
            }
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(begin, begin + res);
    }
}

 public String minWindow(String s, String t) {
        int[] map = new int[128];
        
        for (char c : t.toCharArray()) map[c]++;
        
        int count = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
        
        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) count--;
            while (count == 0) {
                if (end - begin < d) {
                    d = end - begin;
                    head = begin;
                }
                if (map[s.charAt(begin++)]++ == 0) 
                    count++;
            }
        }
        
        return d == Integer.MAX_VALUE ? "" : s.substring(head, head+d);
    }
    
    
      public String minWindow(String s, String t) {
    int [] map = new int[128];
    for (char c : t.toCharArray()) {
      map[c]++;
    }
    int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
    while (end < s.length()) {
      final char c1 = s.charAt(end);
      if (map[c1] > 0) counter--;
      map[c1]--;
      end++;
      while (counter == 0) {
        if (minLen > end - start) {
          minLen = end - start;
          minStart = start;
        }
        final char c2 = s.charAt(start);
        map[c2]++;
        if (map[c2] > 0) counter++;
        start++;
      }
    }

    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
  }
  
  
  
      public String minWindow(String s, String t) {
        int[] cnt = new int[256];
        for (char c : t.toCharArray()) cnt[c]++;
        
        int min = Integer.MAX_VALUE, from = 0, total = t.length();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)]-- > 0) total--;
            while (total == 0) {                    // total=0 means valid window
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }
                if (++cnt[s.charAt(j++)] > 0) total++;
            }
        }
        return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
    }
  
