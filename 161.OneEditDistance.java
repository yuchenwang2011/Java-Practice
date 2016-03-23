161. One Edit Distance My Submissions Question
Total Accepted: 10910 Total Submissions: 38824 Difficulty: Medium
Given two strings S and T, determine if they are both one edit distance apart.

Answer:
public class Solution {
    //"1" "1" is false, "" "" is false, "1" "12" true, "1" "123" false, "1" "2" true, "" "1" true, "1" "23" false
    //"ss1ss" "sss1s"
    //I think this answer is best
    //https://leetcode.com/discuss/71071/my-clear-java-solution-with-explanation
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() == 0 && t.length() == 0) return false;
        if(Math.abs(s.length() - t.length()) > 1) return false;
        
        for(int i = 0; i < Math.min(s.length(),t.length()); i++){
            if(s.charAt(i) != t.charAt(i)) {
                if(s.length() == t.length()){
                    return s.substring(i+1).equals(t.substring(i+1));
                } else if(s.length() > t.length()) {
                    return s.substring(i+1).equals(t.substring(i));
                } else {
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }
        //so now all the chars are the same, once it has "ac" "a" case, we need to check the last digit by checking length
        return Math.abs(s.length() - t.length()) ==1 ;
    }
}
//Test case: "c" "c"
