290. Word Pattern My Submissions Question
Total Accepted: 30727 Total Submissions: 107259 Difficulty: Easy
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

Credits:
Special thanks to @minglotus6 for adding this problem and creating all test cases.

Answer:
//参考205题
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(pattern.length() != words.length) return false;
        
        Map<Character, String> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            char c = pattern.charAt(i);
            String word = words[i];
            
            if(map.containsKey(c)) {
                if(!map.get(c).equals(word)) return false;
            } else {
                if(map.containsValue(word)) return false;
                map.put(c, word);
            }
        }     
        return true;
    }
}
