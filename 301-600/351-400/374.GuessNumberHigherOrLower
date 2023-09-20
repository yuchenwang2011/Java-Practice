374. Guess Number Higher or Lower
Easy 3.4K 430

We are playing the Guess Game. The game is as follows:
I pick a number from 1 to n. You have to guess which number I picked.
Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
You call a pre-defined API int guess(int num), which returns three possible results:
-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is equal to the number I picked (i.e. num == pick).
Return the number that I picked.

Example 1:
Input: n = 10, pick = 6
Output: 6

Example 2:
Input: n = 1, pick = 1
Output: 1

Example 3:
Input: n = 2, pick = 1
Output: 1

Constraints:
1 <= n <= 231 - 1
1 <= pick <= n
Accepted 544.1K Submissions 1M Acceptance Rate 52.5%

Answer:
//my own answer
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if(n <= 0) return -1;
        int start = 1;
        int end = n;
        while(start < end){
            int mid = start + (end - start) / 2;
            int hint = guess(mid);
            if(hint == 0) return mid;
            else if (hint < 0) end = mid - 1;
            else start = mid + 1;
        }

        return start;
    }
}
