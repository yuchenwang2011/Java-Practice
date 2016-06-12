66. Plus One My Submissions Question
Total Accepted: 80918 Total Submissions: 251463 Difficulty: Easy
Given a non-negative number represented as an array of digits, plus one to the number.
The digits are stored such that the most significant digit is at the head of the list.

Answer:
public class Solution {
    public int[] plusOne(int[] digits) {
      int length = digits.length;
      if(length ==0 || digits == null) {
        return new int[]{1};
      }
        
      for(int i = length-1; i >=0 ; i--) {
        if(digits[i] != 9){
          digits[i] = digits[i]+1;
          return digits;
        } 
        digits[i]=0;
      }
      int[] newDigits = new int[length+1];
      newDigits[0] =1;
      return newDigits;
    }
}

//this is my second round answer, i don't know which one of them is better
public class Solution{
  public int[] plusOne(int[] digits){
    if(digits == null || digits.length == 0) return new int[]{1};
    int carry = 0, sum = 0;
    for(int i = digits.length - 1; i >= 0; i--){
      if(i == digits.length -1) {
        sum = digits[i] + carry + 1;
        digits[i] = sum % 10;
        carry = sum / 10;
        continue;
      }
      sum = digits[i] + carry;
      digits[i] = sum % 10;
      carry = sum / 10;
    }
    if(digits[0] == 0 && carry == 1) {
      int[] result = new int[digits.length + 1];
      result[0] = 1;
      return result;
    }
    return digits;
  }
}
