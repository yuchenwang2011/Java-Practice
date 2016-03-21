6. ZigZag Conversion My Submissions Question
Total Accepted: 80520 Total Submissions: 341297 Difficulty: Easy
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

Answer:
public class Solution {
    //n <= 1: PAYPALISHIRING
    //n == 2: PYAIHRNAPLSIIG    PYAIHRN
    //                          APLSIIG
    //
    //n == 3: PAHNAPLSIIGYIR   P   A   H   N
    //                         A P L S I I G
    //                         Y   I   R
    //
    //n == 4: PINALSIGYAHRPI   P     I     N
    //                         A   L S   I G
    //                         Y A   H R 
    //                         P     I
    //
    //n == 5: PHASIYIRPLIGAN   P       H
    //                         A     S I  
    //                         Y   I   R
    //                         P L     I G
    //                         A       N
    //
    //0        6          12          18
    //1     5  7      11  13      17  19
    //2  4     8  10      14  16      20
    //3        9          15          21 
    //https://leetcode.com/discuss/55208/if-you-are-confused-with-zigzag-pattern-come-and-see
    //I copied the answer of this link
    //https://leetcode.com/discuss/10493/easy-to-understand-java-solution
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0) return "";
        if(numRows <= 1) return s;
        char[] str = s.toCharArray();
        //Build an array full of StringBuilder
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();
        int i = 0;
        while(i < str.length){
            for(int j = 0; j < numRows; j ++){
                if (i < str.length) sb[j].append(str[i++]);
            }
            
            for(int j = numRows - 2; j >=1; j--){
                if (i < str.length) sb[j].append(str[i++]);
            }
        }
        String result = "";
        for(int j = 0; j < sb.length; j++){
            result = result + sb[j].toString();
        }
        
        return result;
    }
}
