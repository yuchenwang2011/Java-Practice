306. Additive Number
Medium

Additive number is a string whose digits can form additive sequence.
A valid additive sequence should contain at least three numbers. 
Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Example 1:
Input: "112358"
Output: true
Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8

Example 2:
Input: "199100199"
Output: true
Explanation: The additive sequence is: 1, 99, 100, 199. 
             1 + 99 = 100, 99 + 100 = 199

Constraints:
num consists only of digits '0'-'9'.
1 <= num.length <= 35
Follow up:
How would you handle overflow for very large input integers?

Accepted 44,952 Submissions 156,150

Answer:
//Iterative solution
class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() < 3) return false;
        
        //i是用来substring切出第一个数字的,i是第一个数字的长度
        //第一个数字肯定最多只能总长度一半啊，第二个啥长度不知道，但是如果第一个是一半长，第三个肯定也一半长
        for(int i = 1; i <= num.length() / 2; i++){
            if(num.charAt(0) == '0' && i > 1) return false;
            String s1 = num.substring(0, i);
            //j是用来切第二个数字的，j是第二个数字的长度
            //第三个数字的长度，也就是num.length - i - j，即总长度减去前俩，必须起码要跟前俩最大的一样长
            for(int j = 1; num.length() - i - j >= Math.max(i, j); j++){
                if(num.charAt(i) == '0' && j > 1) break; //注意这里是break
                String s2 = num.substring(i, i + j);
                //看看第三个数字valid不
                if(isValid(num, s1, s2, i + j)) return true;
            }
        }
        return false;
    }
    
    public boolean isValid(String num, String s1, String s2, int start){
        if(start == num.length()) return true;
        String tmp = s2;
        s2 = Long.parseLong(s1) + Long.parseLong(s2) + "";
        s1 = tmp;
        if(!num.startsWith(s2, start)) return false;
        //接着斐波那契下去
        return isValid(num, s1, s2, start + s2.length());
    }
}
