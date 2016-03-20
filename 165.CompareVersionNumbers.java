165. Compare Version Numbers My Submissions Question
Total Accepted: 48323 Total Submissions: 282040 Difficulty: Easy
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Answer:
public class Solution {
    public int compareVersion(String v1, String v2) {
        return process(v1,v2,0,0);
    }
    public int process(String v1, String v2, int l1Dot, int l2Dot){
        if(l1Dot > v1.length()-1 && l2Dot > v2.length()-1) return 0;
        else if (l1Dot > v1.length() -1 || l2Dot > v2.length()-1) {
            if(l1Dot > v1.length()-1) {
                int result = 0;
                for(;l2Dot <= v2.length()-1; l2Dot++) {
                  if(v2.charAt(l2Dot) != '.') result += (v2.charAt(l2Dot) - '0');
                }
                return result == 0? 0 : -1;
            } else {
                int result = 0;
                for(;l1Dot <= v1.length()-1; l1Dot++) {
                  if(v1.charAt(l1Dot) != '.') result += (v1.charAt(l1Dot) - '0');
                }
                return result == 0? 0 : 1;
            }
        }
        
        int l1Result = 0, l2Result = 0;
        while(l1Dot <= v1.length()-1){
            if(v1.charAt(l1Dot) == '.') break;
            l1Result = l1Result * 10 + (v1.charAt(l1Dot) - '0');
            l1Dot++;
        }
        while(l2Dot <= v2.length()-1){
            if(v2.charAt(l2Dot) == '.') break;
            l2Result = l2Result * 10 + (v2.charAt(l2Dot) - '0');
            l2Dot++;
        }
        if(l1Result > l2Result) return 1;
        else if (l1Result < l2Result) return -1;
        else return process(v1,v2,++l1Dot,++l2Dot);
    }
}
