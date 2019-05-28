127. Word Ladder  QuestionEditorial Solution  My Submissions
Total Accepted: 84819
Total Submissions: 430749
Difficulty: Medium
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

Answer:
//Alert!!2019 the question has changed. use this method
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || beginWord.length() != endWord.length() || wordList == null) return 0;
        int distance = 1;
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String each = queue.poll();
                for(int j = 0; j < each.length(); j++){
                    char[] chars = each.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++){
                        chars[j] = c;
                        String s = new String(chars);
                        if(set.contains(s)){
                            if(endWord.equals(s)) return distance + 1;
                            queue.offer(s);
                            set.remove(s);
                        }
                    }
                }
            }
            distance++;
        }
        
        return 0;
    }
}











public class Solution {
    //This explains how Dijkstra algorithm works for shortest path question
    //https://www.youtube.com/watch?v=WN3Rb9wVYDY
    //http://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html
    //This answer is copied from:
    //https://discuss.leetcode.com/topic/20965/java-solution-using-dijkstra-s-algorithm-with-explanation
    
    //就这个解法本身的理解，我感觉应该想象成先捞出一个起点string，然后把这个string咔咔一顿变，各种试，
    //一点点整容，然后挨个和筐里的string们比，只要长一样的就先捞出来，捞完以后手头资源多了，原先那个就扔了
    //然后接着整容这一批，最后循环到捞出来endWord
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || wordList == null) return 0;
        int distance = 1;
        Set<String> reached = new HashSet<String>();
        reached.add(beginWord);
        wordList.add(endWord); //specific to this question
        
        while(!reached.contains(endWord)){
            Set<String> tmp = new HashSet<String>();
            for(String each : reached){
                for(int i  = 0; i < each.length(); i++){
                    char[] chars = each.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++){
                        chars[i] = c;
                        String s = new String(chars);
                        if(wordList.contains(s)){
                            tmp.add(s);
                            wordList.remove(s);
                        }
                    }
                }
            }
            if(tmp.size() == 0) return 0;
            distance++;
            reached = tmp;
        }
        return distance;
    }
}
