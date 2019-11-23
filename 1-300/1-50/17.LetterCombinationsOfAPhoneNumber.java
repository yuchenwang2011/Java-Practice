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
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;
        helper(digits, result, 0, "");
        return result;
    }
    
    public void helper(String digits, List<String> result, int idx, String tmp){
        if(idx >= digits.length()) {
            result.add(tmp);
            return;
        }
        String letters = getLetters(digits.charAt(idx));
        for(int i = 0; i < letters.length(); i++){
            char c = letters.charAt(i);
            helper(digits, result, idx + 1, tmp + c);
        }
    }
    
    public String getLetters(char c){
        if(!Character.isDigit(c)) return "";
        String[] letters = new String[]{"","","abc","def","ghi","jkl","mno","pqrs", "tuv", "wxyz"};
        return letters[c - '0'];
    }
}

//O(4^n) for both time and space complexity
class Solution {
    private static final String[] NUMS = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        while(queue.peek().length() != digits.length()){
            String tmp = queue.poll();
            char c = digits.charAt(tmp.length());
            String letters = NUMS[c - '0'];
            for(int i = 0; i < letters.length(); i++){
                queue.offer(tmp + letters.charAt(i));
            }
        }
        return new ArrayList<>(queue);
    }
}
