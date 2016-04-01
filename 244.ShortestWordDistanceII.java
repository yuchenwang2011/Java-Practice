244. Shortest Word Distance II My Submissions QuestionEditorial Solution
Total Accepted: 6517 Total Submissions: 18524 Difficulty: Medium
This is a follow up of Shortest Word Distance. 
The only difference is now you are given the list of words and your method 
will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, 
and implements a method that takes two words word1 and word2 
and return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

Answer:
public class WordDistance {

    //****Remember don't instantiate the real HashMap object
    private HashMap<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++){
            if(map.containsKey(words[i]) ) map.get(words[i]).add(i); 
            else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i],list);
            }
        } 
    }

    public int shortest(String word1, String word2) {
        int result = Integer.MAX_VALUE;
        if(word1 == null || word2 == null || word1.length() == 0 || word2.length() == 0) return result;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size() ){
            result = Math.min(result, Math.abs(list1.get(i) - list2.get(j)));
            if(list1.get(i) < list2.get(j)) i++;
            else j++;
        }
        return result;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
