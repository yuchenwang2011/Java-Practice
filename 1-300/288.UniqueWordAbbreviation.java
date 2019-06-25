288. Unique Word Abbreviation My Submissions Question
Total Accepted: 7415 Total Submissions: 47442 Difficulty: Easy
An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true

Answer:
public class ValidWordAbbr {
    //Inspired by this answer:
    //https://leetcode.com/discuss/71652/java-solution-with-hashmap-string-string-beats-submissions
    //https://leetcode.com/discuss/86526/let-me-explain-the-question-with-better-examples
    HashMap<String, String> map = new HashMap<String, String>();

    public ValidWordAbbr(String[] dic) {
        for(int i = 0; i < dic.length; i++){
            String key = generateKey(dic[i]);
            // If there is more than one string belong to the same key
            // then the key will be invalid, we set the value to ""
            if(map.containsKey(key)){
                if(map.get(key).equals(dic[i]) == false) map.put(key,"");
            } else {
                map.put(key,dic[i]);
            }
        }
    }

    public boolean isUnique(String word) {
        String key = generateKey(word);
        if(!map.containsKey(key)) return true;;
        if(map.get(key).equals(word)) return true; //because only when there is only 1 key 1 value, not 1 key 2 values. 
        //if 1 key multiple values, value is set to "", so when equals word, means value is not "", it's 1 key 1 value
        return false;
    }
    
    //The key for this problem is d1g, value is dog
    public String generateKey(String s){
        if(s.length() <= 2) return s;
        return s.charAt(0) + Integer.toString(s.length() -2 ) + s.charAt(s.length()-1);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
