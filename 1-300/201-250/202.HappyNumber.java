202. Happy Number My Submissions QuestionEditorial Solution
Total Accepted: 61400 Total Submissions: 169856 Difficulty: Easy
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: 
Starting with any positive integer, replace the number by the sum of the squares of its digits, 
and repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1. 
Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

Answer:
class Solution {
    public boolean isHappy(int n) {
        if(n <= 0) return false;
        Set<Integer> set = new HashSet<>();
        while(n != 1){
            int tmp = 0;
            while(n != 0) {
                tmp += (n % 10) * (n % 10);
                n = n / 10;
            }
            if(set.contains(tmp)) return false;
            set.add(tmp);
            n = tmp;
        } 
        return true;
    }
}
