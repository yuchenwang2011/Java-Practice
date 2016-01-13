243. Shortest Word Distance My Submissions Question
Total Accepted: 6185 Total Submissions: 13642 Difficulty: Easy
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

Answer: 
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
      int idx1 = -1,idx2 = -1;
      int length = Integer.MAX_VALUE;
      for(int i = 0; i < words.length; i++) {
          if(words[i].equals(word1)){
              idx1 = i;
          }
          if(words[i].equals(word2)){
              idx2 = i;
          }
          if(idx1 != -1 && idx2 != -1){
            length = Math.min(length,Math.abs(idx1-idx2));
          }
      }
      return length;
    }
}
