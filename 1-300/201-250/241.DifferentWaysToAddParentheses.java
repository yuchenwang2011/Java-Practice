241. Different Ways to Add Parentheses My Submissions QuestionEditorial Solution
Total Accepted: 19839 Total Submissions: 57754 Difficulty: Medium
Given a string of numbers and operators, return all possible results 
from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1
Input: "2-1-1".
((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]

Example 2
Input: "2*3-4*5"
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]

Answer:
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        if(input == null || input.length() == 0) return result;
        
        //i从1开始也行。0其实是没用的，不过我改成0就是为了好记
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for(int x : left){
                    for(int y : right){
                        if(c == '+') result.add(x + y);
                        if(c == '-') result.add(x - y);
                        if(c == '*') result.add(x * y);
                    }
                }
            }
        }
        if(result.size() == 0) {
            result.add(Integer.valueOf(input));
        }     
        
        return result;
    }
}
