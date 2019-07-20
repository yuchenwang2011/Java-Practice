212. Word Search II
Hard

Given a 2D board and a list of words from the dictionary, find all words in the board.
Each word must be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once in a word.

 
Example:
Input: 
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
 
Note:
All inputs are consist of lowercase letters a-z.
The values of words are distinct.

Answer:
class Solution {
    
    TrieNode root;
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if(board == null || board.length == 0 || board[0].length == 0 
           || words == null || words.length == 0) return result;
        
        buildTrie(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, result, root, words);
            }
        }
        return result;
    }
    
    public void dfs(char[][] board, int i, int j, List<String> result, TrieNode node, String[] words){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#') return;
        char c = board[i][j];
        if(node.children[c - 'a'] == null) return;
        
        board[i][j] = '#';
        node = node.children[c - 'a'];
        if(node.isWord) {
            result.add(node.word);
            node.isWord = false;
            node.word = null;
        }
        
        dfs(board, i - 1, j, result, node, words);
        dfs(board, i + 1, j, result, node, words);
        dfs(board, i, j - 1, result, node, words);
        dfs(board, i, j + 1, result, node, words);
        
        board[i][j] = c;
    }
    
    public void buildTrie(String[] words){
        root = new TrieNode();
        for(String word : words){
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++){
                int j = word.charAt(i) - 'a';
                if(node.children[j] == null) {
                    node.children[j] = new TrieNode();
                }
                node = node.children[j];
            }
            node.isWord = true;
            node.word = word;
        }
    }
    
    public boolean search(TrieNode node, String word){
        if(node == null) return false;
        for(int i = 0; i < word.length(); i++){
            int j = word.charAt(i) - 'a';
            if(node.children[j] == null) return false;
            node = node.children[j];
        }
        return node.isWord;
    }
    
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        String word;
        public TrieNode(){
            children = new TrieNode[26];
            isWord = false;
            word = "";
        }
    }
}
