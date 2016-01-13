28. Implement strStr() My Submissions Question
Total Accepted: 86523 Total Submissions: 363246 Difficulty: Easy
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Answer: 
public class Solution {
    //****Note to Self
    //An unlabeled break statement terminates the innermost switch, for, while, or do-while statement
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(); int l2 = needle.length();
        if (l1 < l2) {
            return -1;
        } 
        if (l2 == 0) {
            return 0;
        }
        int index = -1;
        for (int i = 0; i < l1-l2+1; i++) {
          for(int j = 0;j < l2; j++) {
            if(haystack.charAt(j+i) != needle.charAt(j)) {
                break;
            }
            
            if(j == l2-1){
               index = i;
               return index;
            }
          }
        }
        return index;
    }
}
