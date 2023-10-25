438. Find All Anagrams in a String
Medium 11.9K 321

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 
Constraints:
1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
Accepted 810.1K Submissions 1.6M Acceptance Rate 50.5%

Answer:
//followed this answer
//https://leetcode.com/problems/find-all-anagrams-in-a-string/solutions/92007/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || p == null || p.length() == 0) return result;
        if(p.length() > s.length()) return result;

        Map<Character, Integer> map = new HashMap<>();
        for(Character c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();

        int start = 0;
        int end = 0;
        int head = 0;                   //it's template, useless for this answer
        int length = Integer.MAX_VALUE; //it's template, useless for this answer

        while(end < s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) count--;
            }
            end++;

            while(count == 0){
                char tmp = s.charAt(start);
                if(map.containsKey(tmp)){
                    if(map.get(tmp) == 0) count++;
                    map.put(tmp, map.get(tmp) + 1);
                }

                if(end - start == p.length()) result.add(start);
                start++;
            }
        }
        return result;
    }
}
