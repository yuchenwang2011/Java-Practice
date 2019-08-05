266. Palindrome Permutation My Submissions QuestionEditorial Solution
Total Accepted: 10518 Total Submissions: 20930 Difficulty: Easy
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.

Hint:
1. Consider the palindromes of odd vs even length. What difference do you notice? 
2. Count the frequency of each character.
3. If each character occurs even number of times, then it must be a palindrome. 
    How about character which occurs odd number of times?

Answer:
//必须掌握两种方法
class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0) return true;    
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }      
        return set.size() <= 1;
    }
}

class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        int[] count = new int[256];
        for(char c : s.toCharArray()){
            if(count[c] > 0) {
                count[c]--;
            } else {
                count[c]++;
            }
        }
        int result = 0;
        for(int i = 0; i < count.length; i++){
            if(count[i] != 0) result++;
        }
        return result <= 1;
    }
}
