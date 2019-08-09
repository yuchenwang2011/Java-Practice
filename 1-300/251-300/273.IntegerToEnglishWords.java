273. Integer to English Words
Hard

Convert a non-negative integer to its english words representation. 
Given input is guaranteed to be less than 231 - 1.

Example 1:
Input: 123
Output: "One Hundred Twenty Three"

Example 2:
Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:
Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

Example 4:
Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"

Hint:
1. Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
2. Group the number by thousands (3 digits). You can write a helper function that takes a number less than 1000 
   and convert just that chunk to words.
3. There are many edge cases. What are some good test cases? Does your code work with input such as 0? Or 1000010? 
   (middle chunk is zero and should not be printed out)
   
Answer:
class Solution {
    private String[] less20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"
                                           , "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] tens = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    private String[] thousands = new String[]{"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if(num <= 0) return "Zero";
        String result = "";
        
        int i = 0; 
        while(num != 0){
            if(num % 1000 != 0) {
                result = helper(num % 1000) + thousands[i] + " " + result;
            }
            num /= 1000;
            i++;
        }
        
        return result.trim();
    }
    
   //这里的解法把空格的重任都放在了小于20的if里，也就是为什么主函数里thousand之前没有空格，因为默认这里有一个空格结尾
   //同时也是为什么最后结果要trim一下，因为结尾多一个空格
    public String helper(int n){
        if(n <= 0) return "";
        if(n < 20) return less20[n % 20] + " ";
       //这里之所以用helper而不是less20，是因为helper能给结尾加上一个空格,让空格风格统一
        else if (n < 100) return tens[n / 10] + " " + helper(n % 10);
        else {
            return less20[n / 100] + " Hundred " + helper(n % 100);
        }
    }
}
