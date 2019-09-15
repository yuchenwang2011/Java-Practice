1189. Maximum Number of Balloons  Easy

Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
You can use each character in text at most once. Return the maximum number of instances that can be formed.


Example 1:
Input: text = "nlaebolko"
Output: 1

Example 2:
Input: text = "loonbalxballpoon"
Output: 2

Example 3:
Input: text = "leetcode"
Output: 0
 
Constraints:
1 <= text.length <= 10^4
text consists of lower case English letters only.

Answer:
//my own answer at contest 154
class Solution {
    char[] balloon = new char[]{'b','a','l','o','n'};
    public int maxNumberOfBalloons(String text) {
        if(text == null || text.length() < 5) return 0; 
        
        char[] map = new char[26];
        for(int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            map[c - 'a']++;
        }
        
        int max = Integer.MAX_VALUE;
        for(char c : balloon){
            if(c != 'l' && c != 'o') max = Math.min(max, map[c - 'a']);
            else max = Math.min(max, map[c - 'a'] / 2);
        }
        
        return max;
    }
}
