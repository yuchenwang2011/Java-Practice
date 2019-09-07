38. Count and Say My Submissions Question
Total Accepted: 75132 Total Submissions: 264363 Difficulty: Easy
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Answer:
//Forget all above answers, my own solution May 1st 2019
class Solution {
    public String countAndSay(int n) {
        if(n <= 1) return "1";
        
        String last = countAndSay(n - 1);
        String result = "";
        
        int i = 0;
        while(i < last.length()){
            int count = 0;
            char c = last.charAt(i);
            while(i < last.length() && last.charAt(i) == c) {
                count++;
                i++;
            }
            result = result + count + c;
        }
        return result;
    }
}
