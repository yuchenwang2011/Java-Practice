409. Longest Palindrome
Easy 5.1K 331

Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

Example 1:
Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:
Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 
Constraints:
1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
Accepted 568.3K Submissions 1.1M Acceptance Rate 53.9%

Answer:
//inspired by the comment https://leetcode.com/problems/longest-palindrome/solutions/89604/simple-hashset-solution-java/
class Solution {
    public int longestPalindrome(String s) {
        int result = 0;
        if(s == null || s.length() == 0) return result;
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if(!set.add(c)) set.remove(c);
        }

        int oddCount = set.size();
        return result = s.length() - (oddCount == 0 ? 0 : oddCount - 1);
    }
}
