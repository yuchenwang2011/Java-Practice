28. Implement strStr() My Submissions Question
Total Accepted: 86523 Total Submissions: 363246 Difficulty: Easy
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Answer: 
//My solution April 20, 2019
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        if(haystack == null || haystack.length() == 0) return -1;
        if(haystack.length() < needle.length()) return -1;
        
        char[] hays = haystack.toCharArray();
        char[] nees = needle.toCharArray();
        
        for(int i = 0; i < hays.length - nees.length + 1; i++){
            int j = i;
            int k = 0;
            while(k < nees.length && hays[j] == nees[k]){
                j++;
                k++;
            }
            if(k == nees.length) return i;
        }
        return -1;
    }
}
