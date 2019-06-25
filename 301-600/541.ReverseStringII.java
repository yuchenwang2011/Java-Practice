Question: Given a string and an integer k, you need to reverse the first k characters 
for every 2k characters counting from the start of the string. 
If there are less than k characters left, reverse all of them. 
If there are less than 2k but greater than or equal to k characters, 
then reverse the first k characters and left the other as original.

Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]


class Solution {
    public String reverseStr(String s, int k) {
        if(s == null || s.length() == 0 || k < 1 || k > 10000) return s;
        char[] c = s.toCharArray();
        int i = 0, n = c.length - 1;
        while(i <= n){
            if(i + k <= n){
                reverseHelper(c, i, i + k - 1);
            } else {
                reverseHelper(c, i, n);
            }
            i += k * 2;
        }
        return new String(c);
    }
    
    public void reverseHelper(char[] c, int start, int end){
        while(start < end){
            char tmp = c[end];
            c[end--] = c[start];
            c[start++] = tmp;
        }
    }
}
