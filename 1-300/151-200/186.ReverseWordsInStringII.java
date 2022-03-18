186. Reverse Words in a String II  Medium

Given a character array s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.
Your code must solve the problem in-place, i.e. without allocating extra space.

Example 1:
Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]

Example 2:
Input: s = ["a"]
Output: ["a"]
 
Constraints:
1 <= s.length <= 105
      
s[i] is an English letter (uppercase or lowercase), digit, or space ' '.

There is at least one word in s.
      
s does not contain leading or trailing spaces.

All the words in s are guaranteed to be separated by a single space.
Accepted 129,846 Submissions 256,807

Answer:
import java.util.Arrays;

public class ReverseWordsInString {
      public void reverseWords(char[] s) {
          //first reverse the whole string, then revert each word.
          //the sky is blue --> eulb si yks eht--> blue is sky the
          reverseWord(s,0,s.length-1);
          int begin = 0;
          for(int end =0; end < s.length; end++){
              if(s[end] == ' ' && end != s.length-1) {
                  reverseWord(s,begin,end-1);
                  begin = end+1;
              } else if (end == s.length-1) {
                reverseWord(s,begin,end);
              }
          }         
      }
      
      public void reverseWord(char[] s,int start,int end) {
          int i =start; int j = end;
          while(i<j) {
              char tmp = s[i];
              s[i]=s[j];
              s[j]=tmp;
              i++;j--;
          }
      }
      
      public static void main(String[] args) {
        char[] testData = new char[]{'h','i','!','s'};
        char[] testData2 = new char[]{'h','i','!','s'};
        ReverseWordsInString myReverse = new ReverseWordsInString();
        myReverse.reverseWord(testData,0,testData.length-1);
        myReverse.reverseWords(testData2);
        System.out.println(Arrays.toString(testData));
        System.out.println(Arrays.toString(testData2));
        
        }
}

