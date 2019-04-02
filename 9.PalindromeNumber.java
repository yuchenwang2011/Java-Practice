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

public class Solution {
    //This method is to construct a reverse int of x
    //Got inspired by this answer, the second link is to just compare a half of x
    //https://leetcode.com/discuss/12693/neat-ac-java-code-o-n-time-complexity, I will do it next round
    //https://leetcode.com/discuss/23563/line-accepted-java-code-without-the-need-handling-overflow
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int y = 0;
        int backup = x;
        while(x != 0){
            y = y * 10 + x % 10;
            x = x / 10;
            System.out.println(y);
        }
        return backup == y;
    }
}

Solution: this is a new answer
https://leetcode.com/problems/palindrome-number/discuss/5127/9-line-accepted-Java-code-without-the-need-of-handling-overflow
public boolean isPalindrome(int x) {
    if (x<0 || (x!=0 && x%10==0)) return false;
    int rev = 0;
    while (x>rev){
    	rev = rev*10 + x%10;
    	x = x/10;
    }
    return (x==rev || x==rev/10);
}
