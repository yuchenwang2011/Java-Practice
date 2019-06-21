161. One Edit Distance My Submissions Question
Total Accepted: 10910 Total Submissions: 38824 Difficulty: Medium
Given two strings S and T, determine if they are both one edit distance apart.

Answer:
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() < t.length()) return isOneEditDistance(t, s);
        
        for(int i = 0; i < t.length(); i++){
            if(s.charAt(i) == t.charAt(i)) continue;
            
            if(s.length() == t.length()) {
                return s.substring(i + 1).equals(t.substring(i + 1));
            } else {
                return s.substring(i + 1).equals(t.substring(i));
            }
        }
        return s.length() - t.length() == 1;
    }
}
//Test case: "c" "c"
//"1" "1" is false, "" "" is false, "1" "12" true, "1" "123" false, "1" "2" true, "" "1" true, "1" "23" false
//"ss1ss" "sss1s"
