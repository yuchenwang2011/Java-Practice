387. First Unique Character in a String
Easy
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
Example 1:
Input: s = "leetcode"
Output: 0

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1
 
Constraints:
1 <= s.length <= 105
s consists of only lowercase English letters.
Accepted 1.3M Submissions 2.3M Acceptance Rate 59.4%

Answer:(my own)
class Solution {
    public int firstUniqChar(String s) {
        int idx = -1;
        if(s == null || s.length() == 0) return idx;
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.get(c) == 1){
                idx = i;
                break;
            }
        }
        
        return idx;
    }
}
