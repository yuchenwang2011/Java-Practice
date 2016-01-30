79. Word Search My Submissions Question
Total Accepted: 64108 Total Submissions: 290168 Difficulty: Medium
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

Answer: 
public class Solution {
    //I was inspired by these 3 answers
    //https://leetcode.com/discuss/23165/accepted-very-short-java-solution-no-additional-space
    //https://leetcode.com/discuss/60857/simple-solution
    //https://leetcode.com/discuss/51379/my-java-solution
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        if(word == null ||word.length() == 0) return true;
        
        for(int i =0; i < board.length; i++){
            for(int j= 0; j < board[i].length; j++){
                if(search(board,i,j,word,0) == true) return true; 
            }
        }
        return false;
    }
    public boolean search(char[][] board, int i, int j, String word, int idx){
        if(idx >= word.length()) return true;
        if(i<0 || j<0|| i>=board.length || j>=board[0].length) return false;
        if(board[i][j] == word.charAt(idx)){
          idx++;
          char tmp = board[i][j];
          board[i][j] = '#';
          boolean result = search(board,i,j-1,word,idx) ||
             search(board,i,j+1,word,idx) ||
             search(board,i-1,j,word,idx) ||
             search(board,i+1,j,word,idx);
          board[i][j] = tmp;
          return result;
        }
        return false;
    }
}
//Test case: ["ABCE","SFCS","ADEE"],"ABCCED"
