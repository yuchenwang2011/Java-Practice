132. Palindrome Partitioning II
Hard
Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.

Example:
Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

//this question is same as question 5, try to understand them together
class Solution {
    public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        //最少要砍几刀
        int[] result = new int[s.length()];
        int[][] isPalindrome = new int[s.length()][s.length()];
        
        for(int i = 0; i < s.length(); i++){
            int min = i; //最多就是每个字母都是砍一刀
            for(int j = 0; j <= i; j++){
                if(s.charAt(i) == s.charAt(j) && (i - j <= 1 || isPalindrome[j + 1][i - 1] == 1)) {
                    isPalindrome[j][i] = 1;
                    //这里为啥是result[j - 1]呢，因为你现在求的比如是i = 3；
                    //所以j就从0-3循环。结果大不了就是result[0] + 1, result[1] + 1, result[2] + 1里面最小的一个
                    min = j == 0 ? 0 : Math.min(min, result[j - 1] + 1); 
                }
            }
            result[i] = min;
        }
        return result[result.length - 1];
    }
}



//下面是打印debug版本
class Solution {
    public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        //最少要砍几刀
        int[] result = new int[s.length()];
        int[][] isPalindrome = new int[s.length()][s.length()];
        
        for(int i = 0; i < s.length(); i++){
            int min = i; //最多就是每个字母都是砍一刀
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
