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
public class Solution {
    //the first line is very short but I just can't understand
    //I will try to understand it next round when I know better about HashMap
    //https://leetcode.com/discuss/62374/8-lines-simple-java
    //Copied the method of second link, second one is easy to understand
    //https://leetcode.com/discuss/62876/very-fast-3ms-java-solution-using-hashmap
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(pattern.length() != words.length) return false;
        HashMap<Character, String> map = new HashMap<Character, String>();
        for(int i = 0; i < words.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)) {
                if(map.get(c).equals(words[i]) == false) return false;
            } else {
                if(map.containsValue(words[i]) == true) return false;
                map.put(c,words[i]);
            }
        }
        return true;
    }
}
