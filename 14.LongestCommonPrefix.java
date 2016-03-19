14. Longest Common Prefix My Submissions Question
Total Accepted: 91459 Total Submissions: 330079 Difficulty: Easy
Write a function to find the longest common prefix string amongst an array of strings.

Answer:
public class Solution {
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
        String result = "";
        for(int i = 0; i <= max; i++) {
            result = result + strs[0].charAt(i);
        }
        return result;
    }
}
