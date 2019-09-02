17. Letter Combinations of a Phone Number My Submissions Question
Total Accepted: 74133 Total Submissions: 262324 Difficulty: Medium
Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.

Answer:
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() < 1 || digits.length() > 9) return result;
        
        getCombination(0, "", result, digits);
        return result;
    }
    
    public void getCombination(int start, String tmp, List<String> result, String digits){
        if(start == digits.length()) {
            result.add(tmp);
            return;
        }
        String letters = getLetters(digits.charAt(start));
        for(int i = 0; i < letters.length(); i++){
            getCombination(start + 1, tmp + letters.charAt(i), result, digits);
        }
    }
    
    public String getLetters(char c){
        int number = c - '0';
        if(number > 9 || number < 0) {
            return "";
        } 
        String[] values = new String[]{" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        return values[number];
    }
}
