205. Isomorphic Strings My Submissions Question
Total Accepted: 51343 Total Submissions: 176037 Difficulty: Easy
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character 
while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.

Answer:
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null || s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map.containsKey(c1)) {
                if(map.get(c1) != c2) return false;
            } else {
                if(map.containsValue(c2)) return false;
                map.put(c1, c2);
            }
        }
        return true;
    }
}

class Solution {
    //Note: there are 256 characters in ASCII
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null || s.length() != t.length()) return false;
        int[] map = new int[512];
        for(int i = 0; i < s.length(); i++){
            int c1 = s.charAt(i), c2 = t.charAt(i);
            if(map[c1] != map[c2 + 256]) return false;
            //这里加1是为了不想它等于0，因为如果有array空的地方没有轮到也是等于0的
            map[c1] = map[c2 + 256] = i + 1;
        }
        return true;
    }
}

class Solution {
    //Note: there are 256 characters in ASCII
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null || s.length() != t.length()) return false;
        
        int[] chars1 = new int[256];
        int[] chars2 = new int[256];
        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            //here always make typo mistake
            char c2 = t.charAt(i);
            if(chars1[c1] != chars2[c2]) return false;
            //这里加1是为了不想它等于0，因为如果有array空的地方没有轮到也是等于0的
            chars1[c1] = i + 1;
            chars2[c2] = i + 1;
        }
        
        return true;
    }
}
