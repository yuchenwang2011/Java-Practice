49. Group Anagrams My Submissions Question
Total Accepted: 69731 Total Submissions: 258247 Difficulty: Medium
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.

Answer:
public class Solution {
    //Got inspired by this answer and some knowledge from question 249
    //https://leetcode.com/discuss/58561/share-my-short-java-solution
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0) return result;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String str : strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(map.containsKey(key) == false) map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
      
        //this is too tedious, use this
        //https://leetcode.com/problems/group-anagrams/discuss/19176/Share-my-short-JAVA-solution
        for(String key : map.keySet()){
            List<String> list = map.get(key);
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
}


class Solution {
    //https://www.youtube.com/watch?v=YQbjqVjOESk
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0) return result;
        
        //integer saves which list it is in the final result
        Map<String, Integer> map = new HashMap<>();
        
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String baseStr = String.valueOf(ch);
            if(map.containsKey(baseStr)) {
                List<String> list = result.get(map.get(baseStr));
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                result.add(list);
                map.put(baseStr, result.size() - 1);
            }
        }
        return result;
    }
}
