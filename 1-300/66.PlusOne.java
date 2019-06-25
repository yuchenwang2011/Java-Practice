66. Plus One My Submissions Question
Total Accepted: 80918 Total Submissions: 251463 Difficulty: Easy
Given a non-negative number represented as an array of digits, plus one to the number.
The digits are stored such that the most significant digit is at the head of the list.

Answer:
//https://leetcode.com/problems/plus-one/discuss/24082/My-Simple-Java-Solution
class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return digits;
        
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9) {
                digits[i] ++;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        
        return result;
    }
}


//my own answer May11 2019
class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return digits;
        
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            digits[i] = digits[i] + carry;
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }
        if(carry == 1) {
            int[] result = new int[1 + digits.length];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
