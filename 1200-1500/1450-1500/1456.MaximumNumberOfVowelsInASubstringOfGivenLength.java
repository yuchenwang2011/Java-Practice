1456. Maximum Number of Vowels in a Substring of Given Length
Medium 3K 100
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.

Example 2:
Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.

Example 3:
Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.

Constraints:
1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length
Accepted 180.9K Submissions 310.3K Acceptance Rate 58.3%

Answer:
//my own solution, same methdo as 643
class Solution {
    public int maxVowels(String s, int k) {
        if(s == null || s.length() == 0 || k <= 0) return 0;
        String vowels = "aeiou";
        //the contraints says k <= s.length()

        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += vowels.contains(String.valueOf(s.charAt(i))) ? 1 : 0;
        }

        int i = 1;
        int result = sum;

        while(i + k <= s.length()){
            int left = vowels.contains(String.valueOf(s.charAt(i - 1))) ? 1 : 0;
            int right = vowels.contains(String.valueOf(s.charAt(i + k - 1))) ? 1 : 0;
            sum = sum - left + right;

            result = Math.max(result, sum); 
            i++;           
        }
        return result;
    }
}
