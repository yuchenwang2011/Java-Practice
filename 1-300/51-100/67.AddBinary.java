67. Add Binary My Submissions Question
Total Accepted: 78207 Total Submissions: 289703 Difficulty: Easy
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

Answer:
class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;
        int i = a.length() - 1;
        int j = b.length() - 1;
        String result = "";
        int carry = 0;
        while(i >= 0 || j >= 0){
            int char1 = i >= 0 ? a.charAt(i--) - '0' : 0;
            int char2 = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = char1 + char2 + carry;
            result = (sum % 2) + result;
            carry = sum / 2;
        }
        if(carry != 0) result = "1" + result;
        return result;
    }
}
