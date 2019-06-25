320. Generalized Abbreviation   My Submissions QuestionEditorial Solution
Total Accepted: 5482 Total Submissions: 13444 Difficulty: Medium
Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

Answer:
public class Solution {
    //Got inspired by this answer
    //https://leetcode.com/discuss/75754/java-backtracking-solution
    //The idea is to build a string from scratch and for each of the letter, you just need to think about
    //letter or number, if use letter, current count++, if use number, clear count. of course, when count == 0
    //means you just added a number, you cant add number any more.You can only add a number abbreviation
    //when count == 0
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<String>();
        if(word == null || word.length() == 0) {
            result.add("");
            return result;
        }
        process(word, result, 0, "", 0); //first is idx, second is number how many letters are abbreviated
        return result;
    }
    
    public void process(String word, List<String> result, int start, String tmp, int count){
        if(start == word.length() ){
            if(count > 0) tmp += count;
            result.add(tmp);
            return;
        }
        //一共两种情况
        //接着憋，不加这个了，数字增加
        process(word, result, start + 1, tmp, count + 1);   
         
        ////憋不住了，得加这个了,同时补上前几个的数字
        String numTmp = (count == 0) ? "" : Integer.toString(count);
        process(word, result, start + 1, tmp + numTmp + word.charAt(start), 0); 
    }
}
