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
//O(M * N * 4^L)
class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        if(word == null || word.length() == 0) return true;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char c = word.charAt(0);
                if(board[i][j] == c) {
                    //note here is 0, because you give helper i and j, they match 0, not 1
                    if(helper(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board, String word, int i, int j, int idx){
        if(idx >= word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#') return false;
        char c = board[i][j];
        board[i][j] = '#'; //here we can also board[i][j] ^= 256
        
        if(c == word.charAt(idx)) {
            boolean result = helper(board, word, i - 1, j, idx + 1) 
                || helper(board, word, i + 1, j, idx + 1) 
                || helper(board, word, i, j - 1, idx + 1) 
                || helper(board, word, i, j + 1, idx + 1);
            if(result) return result;
        }
        board[i][j] = c;
        return false;
    }
}
