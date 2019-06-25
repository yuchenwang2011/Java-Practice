50. Pow(x, n) My Submissions QuestionEditorial Solution
Total Accepted: 86957 Total Submissions: 311869 Difficulty: Medium
Implement pow(x, n).

Answer:
public class Solution {
    //https://leetcode.com/discuss/52800/5-different-choices-when-talk-with-interviewers
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        //this line not necessary but easier to understand
        //if(n == -1) return 1/x;
        
        double half = myPow(x, n/2);
        double result = half * half;
        //caution here, you can't use n % 2 == 1
        if(n % 2 != 0) result = (n <0) ? result/x : result * x;
        return result;
    }
}
