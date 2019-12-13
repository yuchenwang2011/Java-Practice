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
class Solution {
    public String convertToTitle(int n) {
        String result = "";
        if(n <= 0) return result;
        
        while(n != 0){
            n--;
            String letter = (char) ('A' + n % 26) + "";
            result = letter + result;
            n = n / 26;
        }
        
        return result;
    }
}

class Solution {
    public String convertToTitle(int n) {
        String result = "";
        if(n <= 0) return result;
        while(n > 0){
            char c = (char) ((n - 1) % 26 + 'A');
            result = c + result;
            n = (n - 1) / 26;
        }
        return result;
    }
}
