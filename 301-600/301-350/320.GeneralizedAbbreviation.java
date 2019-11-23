320. Generalized Abbreviation   My Submissions QuestionEditorial Solution
Total Accepted: 5482 Total Submissions: 13444 Difficulty: Medium
Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

Answer:
class Solution {
    //这个题就是从无开始，一位一位的from scratch去build一个tmp，或者是数字，或者是letter
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        if(word == null || word.length() == 0) {
            result.add("");
            return result;
        }
        helper(word, result, 0, "", 0);
        return result;
    }
    
    public void helper(String word, List<String> result, int start, String tmp, int count){
        if(start == word.length()) {
            if(count > 0) {
                tmp += count;
            }
            result.add(tmp);
            return;
        }
        //注意，这里总是自私的，就考虑自己这一位就好啦，后面的位别考虑，浪费脑细胞
        //第一种选择，不要start这里的letter，然后count + 1
        helper(word, result, start + 1, tmp, count + 1);
        //第二种选择，留着start这里的letter，但是前面积攒的count清零
        helper(word, result, start + 1, tmp + (count == 0 ? "" : count) + word.charAt(start), 0);
    }
}
