9. Palindrome Number My Submissions QuestionEditorial Solution
Total Accepted: 115989 Total Submissions: 369826 Difficulty: Easy
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", 
you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.

Answer:
public class Solution {
    //Test case 1001
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int backup = x; int digit = 0;
        while(backup != 0){
            backup = backup/10; 
            digit++;
        }
        while(digit >= 1){ // 2 or 1 both ok
            int a = x / (int) Math.pow(10,digit-1); //10000 / 10^4 when digit == 5
            int b = x % 10;
            if(a != b) return false;
            x = (x % (int) Math.pow(10,digit-1) - x % 10) / 10; //12345 % 10^4 = 2345, 2345 - 5 = 2340, --> 234
            digit -= 2;
        }
        return true;
    }
}
