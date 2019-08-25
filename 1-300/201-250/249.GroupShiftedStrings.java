249. Group Shifted Strings My Submissions Question
Total Accepted: 7631 Total Submissions: 24559 Difficulty: Easy
Given a string, we can "shift" each of its letter to its successive letter, 
for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
Return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
Note: For the return value, each inner list's elements must follow the lexicographic order.

Answer:
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(strings == null || strings.length == 0) return result;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String str : strings){
            String key = generateKey(str);
            if(map.containsKey(key) == false) {
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(str);
        }

        for(String key : map.keySet()){
            List<String> list = map.get(key);
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
    
    public String generateKey(String str){
        String key = "";
        int offset = str.charAt(0) - 'a';
        for(int i = 0; i < str.length(); i++){
            char c = (char) (str.charAt(i) - offset);
            if(c < 'a') c += 26; //here it must be 26, not 25, because "ba", it should become "az". a - 1 + 26 = z
            key = key + c;
        }
        return key;
    }
}
