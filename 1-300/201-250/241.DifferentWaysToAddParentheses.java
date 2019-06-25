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
public class Solution {
    //Got inspired by these 2 answers
    //https://leetcode.com/discuss/48477/a-recursive-java-solution-284-ms
    //https://leetcode.com/discuss/60626/share-a-clean-and-short-java-solution
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        input = input.trim();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                String part1 = input.substring(0,i);
                String part2 = input.substring(i+1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                for(int p1 : part1Ret){
                    for(int p2 : part2Ret){
                        int tmp = 0;
                        switch(c) {
                            case '+': tmp = p1 + p2; break;
                            case '-': tmp = p1 - p2; break;
                            case '*': tmp = p1 * p2; break;
                        }
                        result.add(tmp);
                    }
                }
            }
        }
        if(result.size() == 0) result.add(Integer.valueOf(input));
        return result;
    }
}
