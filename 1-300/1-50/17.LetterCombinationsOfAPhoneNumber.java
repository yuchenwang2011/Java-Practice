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
//DFS + BFS两种解法
//O(4^n) For DFS/ BFS, you can typically calculate the height of the calculation tree, 
// and then multiply the time complexity of each level of the calculation tree. 
// For this problem, if you press one button, you have 4 choice, if you press N times, 
// you have to multiply N time to build the new String.
class Solution {
    private static final String[] NUMS = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;
        helper(result, digits, 0, "");
        return result;
    }
    public void helper(List<String> result, String digits, int idx, String tmp){
        if(idx >= digits.length()) {
            result.add(tmp);
            return;
        }
        String letters = NUMS[digits.charAt(idx) - '0'];
        for(int i = 0; i < letters.length(); i++){
            char c = letters.charAt(i);
            helper(result, digits, idx + 1, tmp + c);
        }
    }
}


class Solution {
    public List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i =0; i<digits.length();i++){
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length()==i){
				String t = ans.remove();
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;
	}
}
