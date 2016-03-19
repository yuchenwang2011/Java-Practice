14. Longest Common Prefix My Submissions Question
Total Accepted: 91459 Total Submissions: 330079 Difficulty: Easy
Write a function to find the longest common prefix string amongst an array of strings.

Answer:
public class Solution {
    //To understand this question, go to first link
    //https://leetcode.com/discuss/34186/what-does-longest-common-prefix-mean
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        int max = Integer.MAX_VALUE; 
        for(int i = 0; i < strs.length-1; i++){
            int tmp = -1;
            String str1 = strs[i], str2= strs[i+1];
            int length = Math.min(str1.length(), str2.length());
            for(int j = 0; j < length; j++){
                if(str1.charAt(j) == str2.charAt(j)) tmp = j;
                else break;
            }
            if(tmp == -1) {max = -1; break;}
            else max = Math.min(max, tmp);
        }
        if (max == -1) return "";
        //System.out.println("abcd".substring(0,2));
        return max == -1 ? "" : strs[0].substring(0,max+1);
    }
}

public class Solution {
    //Got inspired by this answer
    //https://leetcode.com/discuss/20993/java-code-with-13-lines
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String result = strs[0];
        for(int i = 0; i < strs.length; i++) {
            //shrink the result by 1 each time, because it should begin index at 0
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
