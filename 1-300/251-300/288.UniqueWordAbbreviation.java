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
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. 
     A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true

Answer:
class ValidWordAbbr {
    private Map<String, String> map;
    
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for(String s : dictionary){
            String key = getKey(s);
            if(map.containsKey(key)){
                //只循序同样的string重复，但是不需要出现不同的s但是同样的key
                if(!map.get(key).equals(s)) {
                    map.put(key, "");
                }
            } else {
                map.put(key, s);
            }
        }
    }
    
    public boolean isUnique(String word) {
        String key = getKey(word);
        return !map.containsKey(key) || map.get(key).equals(word);
    }
    
    public String getKey(String s){
        return s.length() <= 2 ? s : s.charAt(0) + "" + (s.length() - 2) + s.charAt(s.length() - 1);
    }
}
