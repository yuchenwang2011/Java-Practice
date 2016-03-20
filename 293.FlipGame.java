293. Flip Game My Submissions Question
Total Accepted: 7244 Total Submissions: 14726 Difficulty: Easy
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].

Answer:
public class Solution {
    //************Remember the usage of subString!!!!!!
    //One more syntax to remember: char[] result = s.toCharArray();
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();
        if(s == null || s.length() <= 1) return result;
        for(int i = 0; i < s.length(); i++){
            if(i < s.length()-1 && s.charAt(i) == '+' && s.charAt(i+1) == '+'){
                String flip = s.substring(0,i) + "--";
                flip = (i+1 == s.length()-1) ? flip : flip + s.substring(i+2,s.length()); 
                result.add(flip);
            }
        }
        return result;
    }
}
//Test case: "", "+","-+","++","+++","+-+","++235x-"
