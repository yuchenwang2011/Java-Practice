132. Palindrome Partitioning II
Hard
Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.

Example:
Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

class Solution {
    //this question is same as question 5, try to understand them together
    public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        //the min times of cuts needed to be able to realize cut total string
        int[] result = new int[s.length()];
        int[][] isPalindrome = new int[s.length()][s.length()];
        
        for(int i = 0; i < s.length(); i++){
            int min = i;
            for(int j = 0; j <= i; j++){
                if(s.charAt(i) == s.charAt(j) && (i - j <= 1 || isPalindrome[j + 1][i - 1] == 1)) {
                    isPalindrome[j][i] = 1;
                    min = j == 0 ? 0 : Math.min(min, result[j - 1] + 1); 
                }
            }
            for(int m = 0; m < s.length(); m++){
                for(int n = 0; n < s.length(); n++){
                    if(n == s.length() - 1) {
                        System.out.println(isPalindrome[m][n]);
                        continue;
                    }
                    System.out.print(isPalindrome[m][n]);
                }
            }
            result[i] = min;
            System.out.println("result " + i + " is: " + result[i] );
            System.out.println("=======");
        }
        return result[result.length - 1];
    }
}
