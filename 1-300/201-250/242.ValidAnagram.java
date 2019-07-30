242. Valid Anagram My Submissions Question
Total Accepted: 50365 Total Submissions: 126225 Difficulty: Easy
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

Answer:
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) return true;
        if(s.length() != t.length()) return false;
        int[] counts = new int[26];
        for(int i = 0; i < s.length(); i++){
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }
        for(int i : counts){
            if(i != 0) return false;
        }
        return true;
    }
}
