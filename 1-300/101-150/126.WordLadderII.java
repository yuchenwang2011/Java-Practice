126. Word Ladder II
Hard

Given two words (beginWord and endWord), and a dictionary's word list, 
find all shortest transformation sequence(s) from beginWord to endWord, such that:
Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:
Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

Example 1:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]

Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

Answer:
//this answer doesn't work
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if(beginWord == null || endWord == null || beginWord.length() != endWord.length() 
           || wordList == null || wordList.size() == 0) return result;
        
        Set<String> visited = new HashSet<>();
        Set<String> unvisited = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int curNum = 1;
        int nextNum = 0;
        boolean found = false;
        Map<String, List<String>> map = new HashMap<>();
        
        while(!queue.isEmpty()){
            String word = queue.poll();
            curNum--;
            for(int i = 0; i < word.length(); i++){
                StringBuilder sb = new StringBuilder(word);
                for(char c = 'a'; c <= 'z'; c++){
                    sb.setCharAt(i, c);
                    String s = sb.toString();
                    if(unvisited.contains(s)) {
                        if(s.equals(endWord)) {
                            found = true;
                        }
                        if(visited.add(s)) {
                            nextNum++;
                            queue.offer(s);
                        }
                        if(map.containsKey(s)){
                            map.get(s).add(word);
                        } else {
                            List<String> list = new ArrayList<>();
                            list.add(word);
                            map.put(s, list);
                        }
                    }
                }
            }
            if(curNum == 0) {
                if(found == true) break;
                curNum = nextNum;
                nextNum = 0;
                unvisited.remove(visited);
                visited.clear();
            }  
        }
        dfs(result, new ArrayList<String>(), map, endWord, beginWord);
        return result;
    }
    
    public void dfs(List<List<String>> result, List<String> list, Map<String, List<String>> map, String word, String start){
        if(word.equals(start)) {
            list.add(0, start);
            result.add(new ArrayList<>(list));
            list.remove(0);
            return;
        }
        list.add(word);
        if(map.get(word) != null) {
            for(String s : map.get(word)){
                dfs(result, list, map, s, start);
            }
        }
        list.remove(0);
    }
}
