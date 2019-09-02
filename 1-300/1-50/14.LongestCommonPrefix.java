14. Longest Common Prefix My Submissions Question
Total Accepted: 91459 Total Submissions: 330079 Difficulty: Easy
Write a function to find the longest common prefix string amongst an array of strings.

Answer:
public class Solution {
    //Got inspired by this answer
    //https://leetcode.com/discuss/20993/java-code-with-13-lines
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String result = strs[0];
        for(int i = 1; i < strs.length; i++) {
            //shrink the result by 1 each time, because it should begin index at 0
            //s.substring(0,0); will return a "";
            while(strs[i].indexOf(result) != 0) result = result.substring(0,result.length()-1);
        }
        return result;
    }
}

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        //***********Remember the usage of StringBuilder API!!!!
        if(strs == null || strs.length == 0 ) return "";
        StringBuilder sb = new StringBuilder(strs[0]);
        for(int i = 0; i < strs.length; i++){
            while(!strs[i].startsWith(sb.toString()) ) sb.deleteCharAt(sb.length() -1 ); 
        }
        return sb.toString();
    }
}
