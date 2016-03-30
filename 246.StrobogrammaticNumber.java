246. Strobogrammatic Number My Submissions QuestionEditorial Solution
Total Accepted: 8514 Total Submissions: 23592 Difficulty: Easy
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.

Answer:
public class Solution {
    //Got inspired by these 2 answers
    //https://leetcode.com/discuss/50594/4-lines-in-java
    //https://leetcode.com/discuss/52273/accepted-java-solution
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('0','0');
        map.put('1','1');
        map.put('6','9');
        map.put('8','8');
        map.put('9','6');
        for(int i = 0 ; i < num.length(); i++){
            if(map.containsKey(num.charAt(i)) && map.get(num.charAt(i)) == num.charAt(num.length() -1 - i)) continue;
            else return false;
        }
        return true;
    }
}

public class Solution {
    //****Remember: review this answer more!
    //This is the second link's result, it's super smart
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() ==0 ) return true;
        for(int i = 0, j = num.length()-1; i <=j; i++, j--){
            if("00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j)) == false) return false;
        }
        return true;
    }
}
