3. Longest Substring Without Repeating Characters My Submissions Question
Total Accepted: 118315 Total Submissions: 559065 Difficulty: Medium
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
For "bbbbb" the longest substring is "b", with the length of 1.

Answer:
//my own answer
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if(s == null || s.length() == 0) return result;
        
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                if(map.get(c) >= start) start = map.get(c) + 1;
            }
            map.put(c, i);
            result = Math.max(result, i - start + 1);
        }        
        return result;
    }
}

//my own answer
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if(s == null || s.length() == 0) return result;
        
        int start = 0;
        //tmmzuxt
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            while(set.contains(c)) {
                set.remove(s.charAt(start++));
            }
            set.add(c);
            result = Math.max(result, i - start + 1);
        }        
        return result;
    }
}
