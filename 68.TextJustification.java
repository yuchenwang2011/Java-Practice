68. Text Justification
Hard
Given an array of words and a width maxWidth, format the text 
such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; 
that is, pack as many words as you can in each line. 
Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. 
If the number of spaces on a line do not divide evenly between words, 
the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.
Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.

Example 1:
Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

Example 2:
Input:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be",
             because the last line must be left-justified instead of fully-justified.
             Note that the second line is also left-justified becase it contains only one word.

Example 3:
Input:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]


Answer:
//from comment of this link: https://leetcode.com/problems/text-justification/discuss/24876/Simple-Java-Solution
class Solution {
//首先要做的就是确定每一行能放下的单词数，这个不难，就是比较n个单词的长度和加上n - 1个空格的长度跟给定的长度L来比较即可
//找到了一行能放下的单词个数，然后计算出这一行存在的空格的个数，是用给定的长度L减去这一行所有单词的长度和。
//得到了空格的个数之后，就要在每个单词后面插入这些空格，这里有两种情况，比如某一行有两个单词"to" 和 "a"，给定长度L为6
//如果这行不是最后一行，那么应该输出"to   a"，如果是最后一行，则应该输出 "to a  "，所以这里需要分情况讨论，最后一行的处理方法和其他行之间略有不同。
//最后一个难点就是，如果一行有三个单词，这时候中间有两个空，如果空格数不是2的倍数，那么左边的空间里要比右边的空间里多加入一个空格，那么我们只需要用总的空格数除以空间个数
//能除尽最好，说明能平均分配，除不尽的话就多加个空格放在左边的空间里"
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if(words == null || words.length == 0 || maxWidth <= 0) return result;
        
        int start = 0;
        while(start < words.length){
            StringBuilder sb = new StringBuilder();
            
            //count：该行所有单词累计总长度
            int count = words[start].length();
            //last:该行最后一个词的index
            int last = start + 1;
            while(last < words.length){
                if(words[last].length() + count + 1 > maxWidth) break;
                //plus one for the space, if its a perfect fit it will fit
                count += 1 + words[last].length();
                //alert: at last, last is out of scope, or it's next line first word
                last++;
            }
            
            int intervals = last - start - 1;
            //append该行第一个单词
            sb.append(words[start]);
            //if this is last line or it's last word, so no invervals
            //words need to be left justified
            //最后一行：每个单词中间一个空格， 剩余补上空白
            if(last == words.length || intervals == 0){
                for(int i = start + 1; i < last; i++){
                    sb.append(" ");
                    sb.append(words[i]);
                }
                for(int i = sb.length(); i < maxWidth; i++){
                    sb.append(" ");
                }
            } else {
                int spaces = (maxWidth - count) / intervals;
                //say there are 5 intervals, each will have 4 spaces
                //but we still have 3 spaces length left to fill
                //so each first 3 intervals each needs fill 1 more space
                //这一行总space的个数：（长度-累计单词总长度）
                //每个单词后面space的个数：（长度-累计单词总长度）/单词个数
                //spacesLeft为需要平均分配到中间的空格总数
                int spacesLeft = (maxWidth - count) % intervals;
                //here i is from start + 1 because we have inserted first word
                for(int i = start + 1; i < last; i++){
                    for(int k = spaces - 1; k >= 0; k--){
                        sb.append(" ");
                    }
                    if(spacesLeft > 0) {
                        sb.append(" ");
                        spacesLeft--;
                    }
                    //他这个最初在算count的数值里包括了1个空格，
                    //所以maxwidth-count的时候 剩余的空格其实是少了count里包括的空格数的，要每次循环再加上
                    sb.append(" ");
                    sb.append(words[i]);
                }
            }
            result.add(sb.toString());
            //starts from next line;
            start = last;
        }
        return result;
    }
}
