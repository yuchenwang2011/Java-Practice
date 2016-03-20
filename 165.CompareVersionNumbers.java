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

public class Solution {
    //Mine solution beats 87%, this is another solution idea beats 10%
    //https://leetcode.com/discuss/32731/java-solution-with-fewer-if-logic
    //***************Remember the usage of split!!!!!
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        for(int i = 0; i < Math.max(v1.length, v2.length); i++ ) {
            int val1 = (i < v1.length) ? Integer.parseInt(v1[i]) : 0;
            int val2 = (i < v2.length) ? Integer.parseInt(v2[i]) : 0;
            
            if(val1 > val2) return 1;
            if(val1 < val2) return -1;
        }
        return 0;
    }
}
