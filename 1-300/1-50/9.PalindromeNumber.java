9. Palindrome Number My Submissions QuestionEditorial Solution
Total Accepted: 115989 Total Submissions: 369826 Difficulty: Easy
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
1. Could negative integers be palindromes? (ie, -1)
2. If you are thinking of converting the integer to string, note the restriction of using extra space.
3.You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", 
4.you know that the reversed integer might overflow. How would you handle such case?
5.There is a more generic way of solving this problem.

Answer:
//两个解法
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int y = 0;
        int backup = x;
        while(x != 0){
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return backup == y;
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)) return false;      
        int tmp = 0;
        int backup = x;
        while(x != 0){
            tmp = tmp * 10 + x % 10;
            x /= 10;
            if(x == tmp || (x / 10 == tmp)) return true;
        }
        return tmp == backup;
    }
}
