67. Add Binary My Submissions Question
Total Accepted: 78207 Total Submissions: 289703 Difficulty: Easy
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

Answer:
public class Solution {
    public String addBinary(String a, String b) {
        if(a == null || b == null) return a == null? b : a;
        if(a.length() == 0 || b.length() == 0) return a.length() ==0 ? b : a;
        
        int la = a.length(), lb = b.length();
        String c = ""; int carry = 0;
        while(la != 0 && lb != 0){
            int valA = a.charAt(la-1) - '0', valB = b.charAt(lb-1) - '0';
            if(valA > 1 || Character.isLetterOrDigit(a.charAt(la-1)) == false) return "";
            if(valB > 1 || Character.isLetterOrDigit(b.charAt(lb-1)) == false) return "";
            int sum = valA + valB + carry;
            c = (sum%2) + c;
            carry = sum >= 2? 1 : 0;
            la--; lb--;
        }
        while(la != 0){
            int sum = a.charAt(la-1) - '0' + carry;
            carry = sum >= 2? 1 : 0;
            c = (sum%2) + c;
            la --;
        }
        while(lb != 0){
            int sum = b.charAt(lb-1) - '0' + carry;
            carry = sum >= 2? 1 : 0;
            c = (sum%2) + c;
            lb --;
        }
        if(carry != 0) c = "1" + c;
        return c;
    }
}
