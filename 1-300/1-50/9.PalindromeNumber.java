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
//两个解法
public class Solution {
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

https://leetcode.com/problems/palindrome-number/discuss/5127/9-line-accepted-Java-code-without-the-need-of-handling-overflow
public boolean isPalindrome(int x) {
    if (x<0 || (x!=0 && x%10==0)) return false;
    int rev = 0;
    while (x>rev){
    	rev = rev*10 + x%10;
    	x = x/10;
    }
    //Because a Palindrome Number's length() can be odd or even, 
    //when it's odd(such as 121, x = 1, rev = 12), x should be rev/10 for making sure it is a Palindrome Number; 
    //the same reason, when it's even(such as 1221, x = 12, rev = 12), x should be rev.
    return (x==rev || x==rev/10);
}
