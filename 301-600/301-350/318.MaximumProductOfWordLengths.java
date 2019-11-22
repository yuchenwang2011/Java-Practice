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
class Solution {
    public int maxProduct(String[] words) {
        if(words == null || words.length < 2) return 0;
        int[] bytes = new int[words.length];
        for(int i = 0; i < bytes.length; i++){
            String word = words[i];
            for(int j = 0; j < word.length(); j++){
                bytes[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        
        int result = 0;
        for(int i = 0; i < bytes.length - 1; i++){
            for(int j = i + 1; j < bytes.length; j++){
                if((bytes[i] & bytes[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }
}
