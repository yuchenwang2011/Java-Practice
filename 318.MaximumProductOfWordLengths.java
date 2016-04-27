318. Maximum Product of Word Lengths   My Submissions QuestionEditorial Solution
Total Accepted: 19425 Total Submissions: 48955 Difficulty: Medium
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) 
where the two words do not share common letters. You may assume that each word will contain only lower case letters. 
If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.

Answer:
public class Solution {
    //Got inspired by this answer
    //https://leetcode.com/discuss/76489/java-solution-with-comments
    public int maxProduct(String[] words) {
        if(words == null || words.length < 2) return 0;
        int[] checker = new int[words.length];
        for(int i = 0; i < words.length; i++){
            int val = 0;
            for(int j = 0; j < words[i].length(); j++){
                val |= 1 << (words[i].charAt(j) - 'a'); //give each appeared letter a '1' in the 32bits integer val
            }
            checker[i] = val;
        }
        int result = 0;
        for(int i = 0; i < words.length - 1; i++){
            for(int j = i + 1; j < words.length; j++){
                if( (checker[i] & checker[j]) == 0 ) result = Math.max(result, words[i].length() * words[j].length()); 
            }
        }
        return result;
    }
}
