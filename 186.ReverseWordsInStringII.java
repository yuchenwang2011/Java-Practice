Given an input string, reverse the string word by word. 
A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces and the words are always separated 
by a single space.
For example,
Given s = "the sky is blue",
return "blue is sky the".
Could you do it in-place without allocating extra space?

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

