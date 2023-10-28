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
先把所有的都存map里，然后复制个map，暴力循环，从新map里见到一次减一次
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        if(s.length() < words.length * words[0].length()) return result;

        Map<String, Integer> map = new HashMap<>();
        for(String w : words){
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        for(int i = 0; i < s.length() - words.length * words[0].length() + 1; i++){
            int j = i;
            int k = words.length;
            Map<String, Integer> map2 = new HashMap<>(map);
            while(k > 0){
                String tmp = s.substring(j, j + words[0].length());
                if(map2.containsKey(tmp) && map2.get(tmp) > 0) {
                    map2.put(tmp, map2.get(tmp) - 1);
                    j += words[0].length();
                    k--;
                } else {
                    break;
                }
            }
            if(k == 0) result.add(i);
        }
        return result;
    }
}
