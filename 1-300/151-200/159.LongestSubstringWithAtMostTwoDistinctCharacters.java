159. Longest Substring with At Most Two Distinct Characters
Medium

Given a string s , find the length of the longest substring t that contains at most 2 distinct characters.

Example 1:
Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
    
Example 2:
Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
Accepted 86,501 Submissions 179,089
    
Answer:
//我自己的方法
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;
        int maxLength = 1;
        
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            map.put(c, map.getOrDefault(c, 0) + 1);

            if(map.size() <= 2) {
                maxLength = Math.max(i - start + 1, maxLength);
            }
            while(map.size() > 2){
                char d = s.charAt(start);
                if(map.get(d) == 1) {
                    map.remove(d);
                } else {
                    map.put(d, map.get(d) - 1);
                }
                start++;
            }
        }   
        return maxLength;
    }
}
