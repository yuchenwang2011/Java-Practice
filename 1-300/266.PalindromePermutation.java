266. Palindrome Permutation My Submissions QuestionEditorial Solution
Total Accepted: 10518 Total Submissions: 20930 Difficulty: Easy
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.

Hint:

Consider the palindromes of odd vs even length. What difference do you notice?
Count the frequency of each character.
If each character occurs even number of times, then it must be a palindrome. 
How about character which occurs odd number of times?

Answer:
public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0 ) return true;
        HashMap<Character, Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)) map.put(c,map.get(c) + 1);
            else map.put(c,1);
        }
        int oddCount = 0;
        for(char c : map.keySet()){
            if(map.get(c) % 2 == 1) oddCount++;
        }
        return oddCount <= 1;
    }
}

public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0 ) return true;
        HashMap<Character, Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)) map.remove(c);
            else map.put(c,1);
        }
        return map.size() <=1;
    }
}

public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0 ) return true;
        int[] result = new int[256];
        for(int i = 0; i < s.length(); i++){
            int num = s.charAt(i);
            if(result[num] == 1) result[num]--;
            else result[num]++;
        }
        int count = 0;
        for(int i = 0; i < 256; i++){
            if(result[i] %2 == 1) count ++;
        }
        return count <= 1;
    }
}
