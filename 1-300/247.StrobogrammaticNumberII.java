247. Strobogrammatic Number II My Submissions QuestionEditorial Solution
Total Accepted: 7716 Total Submissions: 22698 Difficulty: Medium
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].

Hint:

Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.

Answer:
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<String>();
        if(n <=0) {
            result.add("");
            return result;
        }
        if(n == 1){
            result.add("0");
            result.add("1");
            result.add("8");
            return result;
        }
        if(n % 2 == 1) process(n, result, "", n/2, n/2);
        else process(n, result, "", n/2-1, n/2);
        return result;
    }
    
    public void process(int n, List<String> result, String tmp, int start, int end){
        if(start < 0 && end >= n){
            result.add(tmp);
            return;
        }
        
        if(start == end){
            process(n, result, "0", start-1, end+1);
            process(n, result, "1", start-1, end+1);
            process(n, result, "8", start-1, end+1);
        } else {
            if(start != 0) process(n, result, "0" + tmp + "0", start-1, end+1);
            process(n, result, "1" + tmp + "1", start-1, end+1);
            process(n, result, "6" + tmp + "9", start-1, end+1);
            process(n, result, "8" + tmp + "8", start-1, end+1);
            process(n, result, "9" + tmp + "6", start-1, end+1);
        }
    }
}
