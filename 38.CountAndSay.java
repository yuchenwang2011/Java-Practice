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
public class Solution {
    public String countAndSay(int n) {
        //1,11,21,1211,111221,312211,13112221,1113213211,31131211131221
        if(n == 1) return "1";
        String lastResult = countAndSay(n-1);
        String result = "";
        int count = 1;
        for(int i = 0; i < lastResult.length(); i++ ){
            if(i <= lastResult.length() - 2 && lastResult.charAt(i+1) == lastResult.charAt(i)){
               count ++;
               continue;
            } else {
                result = (count == 1)? result + "1" + lastResult.charAt(i) : result + count + lastResult.charAt(i); 
                count = 1;
            }
        }
        return result;
    }
}

//this is my second round solution, maybe a little bit easier to understand
public class Solution {
    public String countAndSay(int n) {
        if(n <= 0) return "";
        if(n == 1) return "1";
        String lastResult = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 0; i < lastResult.length(); i++){
            if(i < lastResult.length() - 1 && lastResult.charAt(i) == lastResult.charAt(i+1)) {
                count++; continue;
            }
            String tmp = count + "" + lastResult.charAt(i);
            count = 1;
            sb.append(tmp);
        }
        return sb.toString();
    }
}

//Third round Oct 6, 2017, similar to above two solutions
class Solution {
    public String countAndSay(int n) {
        if(n < 0) return "";
        if(n <= 1) return "1";
        String last = countAndSay(n - 1);
        String result = "";
        int i = 0;
        while(i < last.length()){
            if(i < last.length() - 1 && last.charAt(i) == last.charAt(i+1)) {
                int count = 1;
                while(i < last.length() - 1 && last.charAt(i) == last.charAt(i+1)) {
                    i++;
                    count++;
                }
                result = result + count + last.charAt(i);
                i++;
                continue;
            } 
            result = result + "1" + last.charAt(i);
            i++;
        }
        return result;
    }
}


//Forget all above answers, my own solution May 1st 2019
class Solution {
    public String countAndSay(int n) {
        if(n <= 1) return "1";
        
        String last = countAndSay(n - 1);
        String result = "";
        int start = 0;

        while(start < last.length()){
            int count = 0;
            char c = last.charAt(start);
            while(start < last.length() && last.charAt(start) == c) {
                count++;
                start++;
            }
            result = result + count + c;
        }
        return result;
    }
}
