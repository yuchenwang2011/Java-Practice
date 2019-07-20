211. Add and Search Word - Data structure design
Medium

Design a data structure that supports the following two operations:
void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A .
means it can represent any one letter.

Example:
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

Note:
You may assume that all words are consist of lowercase letters a-z.

Answer:
class WordDictionary {

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
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(root, word, 0);
    }
    
    public boolean helper(TrieNode node, String word, int idx){
        //here you can't use a for loop, if use for, it will be iteratively going through all letters
        //but some of the letters are '.', they needs recursive. iterative can't be used same time as recursive
        //so better recursive for both cases
        if(idx == word.length()) return node.isWord;
        
        if(word.charAt(idx) == '.') {
            for(TrieNode child : node.children){
                if(child != null && helper(child, word, idx + 1)) return true;
            }
            return false;
        } else {
            int j = word.charAt(idx) - 'a';
            if(node.children[j] == null) return false;
            return helper(node.children[j], word, idx + 1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
