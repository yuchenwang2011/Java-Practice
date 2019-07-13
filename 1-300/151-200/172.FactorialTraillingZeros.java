172. Factorial Trailing Zeroes My Submissions QuestionEditorial Solution
Total Accepted: 55251 Total Submissions: 170197 Difficulty: Easy
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Answer:
//你除以5，第一遍就是发现有多少个5；你再除以5，第二遍就是发现有多少个25。再多少个125.。。
class Solution {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 +  trailingZeroes(n / 5);
    }
}

//think this way: 12345,678910. only 5 x 2 makes a zero. and there are way more 2s than 5s.
//so actually just to count how many 5s there are. so 5, 10, 15, 20, 25, 30....125.
//they have 1,1,1,1,2 number of fives, every 5 number has an extra 5.
class Solution {
    public int trailingZeroes(int n) {
        int result = 0;
        if(n <= 0) return 0; 
        
        while(n != 0){
            result += n / 5;
            n /= 5;
        }
        return result;
    }
}
