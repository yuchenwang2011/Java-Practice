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
//********Remember: must use break when using switch!!
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null || digits.length() ==0) return result;
        process(digits,result,0,"");
        return result;
    }
    
    public void process(String digits, List<String> result, int idx, String tmp){
        if(idx >= digits.length()) {
            result.add(tmp);
            return;
        }
        String s = convert(digits.charAt(idx));
        for(int j = 0; j < s.length(); j++) {
            process(digits,result,idx+1,tmp + s.charAt(j));
        }
    }
    
    public String convert(char c){
        int val = c - '0';
        String result = "";
        if(c == '*' || c == '#') return "";
        switch(val){
            case 1: case 0: result = "";break;
            case 2: result = "abc"; break;
            case 3: result = "def"; break;
            case 4: result ="ghi";  break;
            case 5: result = "jkl"; break;
            case 6: result = "mno"; break;
            case 7: result = "pqrs";break;
            case 8: result = "tuv"; break;
            case 9: result = "wxyz";break;
            default: break;
        }
        return result;
    }
}
