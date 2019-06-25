30. Substring with Concatenation of All Words
Hard
You are given a string, s, and a list of words, words, that are all of the same length. 
Find all starting indices of substring(s) in s that is a concatenation 
of each word in words exactly once and without any intervening characters.
Example 1:
Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.

Example 2:
Input:
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
Output: []


Solution:
//https://www.youtube.com/watch?v=L6NLra-rZoU
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || words == null || words.length == 0) return result;
        if(words[0] == null || s.length() < words[0].length() * words.length) return result;
        
        Map<String, Integer> map = new HashMap<>();
        for(String str : words){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        int n = words.length;
        int m = words[0].length();
        for(int i = 0; i < s.length() - m * n + 1; i++){
            int j = i;
            int k = n;
            Map<String, Integer> newMap = new HashMap<>(map);
            while(k > 0){
                String tmp = s.substring(j, j + m);
                if(!newMap.containsKey(tmp) || newMap.get(tmp) < 1) break;
                newMap.put(tmp, newMap.get(tmp) - 1);
                j = j + m;
                k--;
            }
            if(k == 0) result.add(i);
        }
        return result;
    }
}
