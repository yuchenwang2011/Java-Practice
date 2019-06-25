168. Excel Sheet Column Title My Submissions QuestionEditorial Solution
Total Accepted: 56898 Total Submissions: 265787 Difficulty: Easy
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    
Answer:
public class Solution {
    public String convertToTitle(int n) {
        if(n <= 0) return "";
        String result = "";
        while(n > 0){
            int a = n % 26;
            if(a == 0) {
                result = "Z" + result;
                a += 26;
            }
            else {
                String letter = (char) ('A' - 1 + a) + "";
                result = letter + result;
            }
            n = (n - a) / 26;
        }
        return result;
    }
}

public class Solution {
    //Got inspired by this answer:
    //https://leetcode.com/discuss/24116/the-way-i-come-up-with-my-solution
    // n = 26x + r
    // n - 1 = 26x + (r-1) 
    // r -1 = (n -1) % 26 and x = (n - 1 - (r-1)) /26
    public String convertToTitle(int n) {
        String result = "";
        while(n > 0){
            int a = (n -1) % 26; 
            result = (char) ('A' + a) + result;
            n = (n - 1 - a) / 26;
        }
        return result;
    }
}
