Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:
s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.

Example 1:
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:
Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

Example 4:
Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".

Example 5:
Input:
s = "acdcb"
p = "a*c?b"
Output: false


Answer: 
//need to understand question: bcare matches *e
//https://www.youtube.com/watch?v=-8QnRMyHo_o&t=186s
class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null ) return false;
        
        int sp = 0;
        int pp = 0;
        int star = -1;
        int match = 0;
        
        while(sp < s.length()){
            if(pp< p.length() && (p.charAt(pp) == '?' || p.charAt(pp) == s.charAt(sp))) {
                sp++;
                pp++;
            } else if (pp< p.length() && p.charAt(pp) == '*') {
                star = pp;
                //keep track of last time where the star matches s
                match = sp;
                //move pp to next digit, don't want it keep stay in * position
                pp++;
            } else if (star != -1){
                //that means nothing matches for pp and sp, so now want to check if * still in effect
                //把pp按住别动，因为现在一直在检查*，你就保持在星的下一个待着就行
                pp = star + 1;
                match++;
                //this sp = match is useful, because "abcde" matches "*bcee"
                //at first after you find first *, then you keep going to first if equal condition
                //突然到结尾你发现不好使了，后悔了就得回来看看找备胎*，找回当初match的位置，当然match得++
                sp = match;
            } else {
                return false;
            }
        }
        
        while(pp < p.length()){
            if(p.charAt(pp++) != '*') {
                return false;
            }
        }
        return pp == p.length();
    }
}
