294. Flip Game II   My Submissions QuestionEditorial Solution
Total Accepted: 8894 Total Submissions: 21458 Difficulty: Medium
You are playing the following Flip Game with your friend: 
Given a string that contains only these two characters: + and -, 
you and your friend take turns to flip two consecutive "++" into "--". 
The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm's runtime complexity.

Answer:
public class Solution {
    //Got inspired by this answer
    //https://leetcode.com/discuss/64291/share-my-java-backtracking-solution
    public boolean canWin(String s) {
        if(s == null || s.length() < 2) return false;
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        return canWin(s,map);
    }
    
    public boolean canWin(String s, HashMap<String, Boolean> map){
        if(map.containsKey(s)) return map.get(s);
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                String opponent = s.substring(0,i) + "--" + s.substring(i+2, s.length());
                if(!canWin(opponent,map)){
                    map.put(s,true);
                    return true;
                }
            }
        }
        map.put(s,false);
        return false;
    }
    
}
