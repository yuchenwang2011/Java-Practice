394. Decode String
Medium 11.6K 522

Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. 
Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. 
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. 
For example, there will not be input like 3a or 2[4].
The test cases are generated so that the length of the output will never exceed 105.

Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

Constraints:
1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
Accepted 685.9K Submissions 1.2M Acceptance Rate 58.3%

Answer:
//followed this answer: https://leetcode.com/problems/decode-string/solutions/87570/simple-1-pass-java-solution-with-only-1-stack-with-explanation5
class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c != ']'){
                stack.push(c); //push everything but ']'
            } else {
                //step 1: if a ']', retrieve the string
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isLetter(stack.peek())){
                    sb.insert(0, stack.pop());
                }
                String sub = sb.toString(); // this is the string in []
                stack.pop(); //discard the '['

                //step2: find the number to repeat
                sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    sb.insert(0, stack.pop());
                }
                int count = Integer.valueOf(sb.toString());

                //step3: repeat the string in [] count times and push it to stack
                while(count > 0){
                    for(char ch : sub.toCharArray()){
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }

        //finally return the string
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}
