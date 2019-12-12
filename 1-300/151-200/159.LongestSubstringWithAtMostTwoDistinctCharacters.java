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
//跟着例子走一遍就行
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int result = 0;
        if(s == null || s.length() == 0) return result;
        
        int first = 0;
        int second = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(second < s.length()){
            if(map.size() <= 2) {
                map.put(s.charAt(second), second);
                second++;
            }
            //注意这里不能写成else，因为上面如果操作了size变大了，下面就需要执行了
            if(map.size() > 2) {
                int newStart = s.length() - 1;
                for(int i : map.values()){
                    newStart = Math.min(newStart, i);
                }
                map.remove(s.charAt(newStart));
                first = newStart + 1;
            }
            result = Math.max(result, second - first);
        }
        return result;
    }
}
