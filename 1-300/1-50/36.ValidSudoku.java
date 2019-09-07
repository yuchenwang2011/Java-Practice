36. Valid Sudoku My Submissions Question
Total Accepted: 68868 Total Submissions: 228054 Difficulty: Easy
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

http://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png

A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

Answer:
public class Solution {
    //After reading the question, I think it's saying that if 1 column/row, the value only appears once,
    //and in a sub box, the value only appears once, it can be said as a valid sudoku
    //It has 3 main stream solutions, I will use the first one this round
    //https://leetcode.com/discuss/27272/shared-my-concise-java-code
    //https://leetcode.com/discuss/17990/sharing-my-easy-understand-java-solution-using-set
    //https://leetcode.com/discuss/30471/share-my-solution-for-valid-sudoku
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0 || board.length != board[0].length) return false;
        if(board.length > 9 || board[0].length > 9) return false;
        
        for(int i = 0 ; i < board.length; i++){
            HashSet<Character> row = new HashSet<Character>();
            HashSet<Character> col = new HashSet<Character>();
            HashSet<Character> box = new HashSet<Character>();
            //think about i increase from 0 to 9, the box moves first right then down
            //so the final index for box is: 00, 03, 06, 30, 33, 36, 60, 63, 66
            //记住口诀：先除再余
            int boxRowStart = 3 * (i/3), boxColStart = 3 * (i%3);
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.' && row.add(board[i][j]) == false) return false;
                if(board[j][i] != '.' && col.add(board[j][i]) == false) return false;
                char c = board[boxRowStart + j/3][boxColStart + j%3];
                if(c != '.' && box.add(c) == false) return false;
            }
        }
        return true;
        
    }
}

//时隔几年，大神又弄出来了个新方法
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        
        Set<String> set = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                char c = board[i][j];
                if(c == '.') continue;
                String row = c + " in row " + i;
                String col = c + " in col " + j;
                String box = c + " in box " + i / 3 + "-" + j / 3;
                if(!set.add(row) || !set.add(col) || !set.add(box)) return false;
            } 
        }
        
        return true;
    }
}
