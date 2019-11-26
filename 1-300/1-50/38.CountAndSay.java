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
class Solution {
    public String countAndSay(int n) {
        if(n <= 0) return "";
        if(n == 1) return "1";
        String last = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        
        int count = 1;
        for(int i = 0; i < last.length(); i++){
            if(i == (last.length() - 1) || last.charAt(i) != last.charAt(i + 1)) {
                sb.append(count + "");
                sb.append(last.charAt(i));
                count = 1;
            } else {
                count++;
            }
        }   
        return sb.toString();
    }
}
