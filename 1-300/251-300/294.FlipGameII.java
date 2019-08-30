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
class Solution {
    public boolean canWin(String s) {
        if(s == null || s.length() < 2) return false;
        Set<String> set = new HashSet<>();
        return canWin(s, set);
    }
    
    public boolean canWin(String s, Set<String> set){
        if(set.contains(s)) return false;
        int i = 0;
        while(i < s.length() && s.indexOf("++", i) != -1){
            int start = s.indexOf("++", i);
            String flip = s.substring(0, start) + "--" + s.substring(start + 2);
            if(!canWin(flip, set)) return true;
            i = start + 1;
        }
        set.add(s);
        return false;
    }
}
