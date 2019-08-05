269. Alien Dictionary
Hard

There is a new alien language which uses the latin alphabet. 
However, the order among letters are unknown to you. 
You receive a list of non-empty words from the dictionary, 
where words are sorted lexicographically by the rules of this new language. 
Derive the order of letters in this language.

Example 1:
Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
Output: "wertf"

Example 2:
Input:
[
  "z",
  "x"
]
Output: "zx"

Example 3:
Input:
[
  "z",
  "x",
  "z"
] 
Output: "" 
Explanation: The order is invalid, so return "".

Note:
You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.

Answer:
class Solution {
    //第一步，把所有字母都存到indegree[]里,把indegree初始化全变成1
    //第二步，比较前一个word和后一个word，一旦出现不同字母，增加后一个字母的indegree
    //第三步，用bfs，把indegree从1到后逐渐加到结果里
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        
        int count = 0;
        int[] indegree = new int[26];
        for(String word : words){
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(indegree[c - 'a'] == 0) {
                    indegree[c - 'a']++;
                    count++;
                }
            }
        }
        
        Map<Character, Set<Character>> map = new HashMap<>();
        for(int i = 0; i < words.length - 1; i++){
            //就是每个字母比较，要是不相等，多出来的长度没有字母跟它比较啊，咋判断到底哪个在前
            int len = Math.min(words[i].length(), words[i + 1].length());
            for(int j = 0; j < len; j++){
                char current = words[i].charAt(j);
                char next = words[i + 1].charAt(j);
                if(current != next) {
                    //这个就跟搞传销似的，next是current的下线，每个current都有个set通信录，里面全是自己的下线
                    if(!map.containsKey(current)) {
                        map.put(current, new HashSet<>());
                    }
                        
                    if(map.get(current).add(next)){
                        indegree[next - 'a']++;
                    }
                    //两个单词就第一次出现不同的时候对推理判断有用，后面就无法提供信息了，所以继续下一轮训练
                    break;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 1) queue.offer((char) (i + 'a'));
        }
        while(!queue.isEmpty()){
            char c = queue.poll();
            sb.append(c);
            //这里因为刚才比较两个word的时候，有的字母没有比较过，所以没有下线。但是在第一轮算indegree时候已经加进去了
            if(map.containsKey(c)) {
                for(char ch : map.get(c)){
                    if(--indegree[ch - 'a'] == 1) {
                        queue.offer(ch);
                    }
                }
            }
        }
        
        //最后得到的字母跟count对不上号，可能有的字母跟谁都没关系，反正是有问题
        if(sb.length() != count) return "";
        return sb.toString();
    }
}
