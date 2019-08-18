1160. Find Words That Can Be Formed by Characters
Easy


You are given an array of strings words and a string chars.
A string is good if it can be formed by characters from chars (each character can only be used once).
Return the sum of lengths of all good strings in words.

Example 1:
Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: 
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.

Example 2
Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: 
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 
Note:
1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
All strings contain lowercase English letters only.
Accepted 2,809 Submissions 3,961

Answer:
//这是我是自己在contest 150里的回答
class Solution {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        if(words == null || words.length == 0 || chars == null || chars.length() == 0) return result;
        int[] map = new int[26];
        for(int i = 0; i < chars.length(); i++){
            char c = chars.charAt(i);
            map[c - 'a']++;
        }
        
        for(String word : words){
            boolean match = true;
            int[] newMap = map.clone();
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                newMap[c - 'a']--;
                if(newMap[c - 'a'] < 0) {
                    match = false;
                    break;
                }
            }
            if(match) result += word.length();   
        }
        return result;
    }
}
