245. Shortest Word Distance III My Submissions Question
Total Accepted: 4496 Total Submissions: 9915 Difficulty: Medium
This is a follow up of Shortest Word Distance. The only difference is now word1 
could be the same as word2.
Given a list of words and two words word1 and word2, return the shortest distance 
between these two words in the list.
word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.

Note:
You may assume word1 and word2 are both in the list.

Answer:
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
       int loc1 = -1, loc2 = -1; int distance = Integer.MAX_VALUE;
       if(words.length < 2){
           return distance;
       }

       for (int i =0 ; i < words.length; i++) {
           if(words[i].equals(word1)) {
               loc1 = i;
           }
           if(words[i].equals(word2)) {
               if(word1.equals(word2)){
                   loc1 = loc2;
               }
               loc2 = i;
           }
           if (loc1 != -1 && loc2 != -1) {
               distance = Math.min(Math.abs(loc1-loc2),distance);
           }
           
       }
       return distance;
    }
}
