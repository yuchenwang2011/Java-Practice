131. Palindrome Partitioning
Medium
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.

Example:
Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

Answer:
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(result, new ArrayList<String>(), s, 0);
        return result;
    }

    public void helper(List<List<String>> result, List<String> tmp, String s, int idx){
        if(idx >= s.length()) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = idx; i < s.length(); i++){
            String s1 = s.substring(idx, i + 1);
            if(isPalindrome(s1)) {
                tmp.add(s1);
                helper(result, tmp, s, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s){
        if(s == null || s.length() == 0) return true;
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
