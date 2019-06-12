157. Read N Characters Given Read4 My Submissions Question
Total Accepted: 10377 Total Submissions: 35269 Difficulty: Easy
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function will only be called once for each test case.

Answer:
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
//It was really hard for me to understand this question, even after reading the code
//But this answer is very good and read its explanation
//https://leetcode.com/discuss/19573/accepted-clean-java-solution
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    //this question asks to read n chars from a file and write into buf array, then return the index;
    //but you can only read 4 letters a time
    public int read(char[] buf, int n) {
        int total = 0;
        char[] smallBuf = new char[4];
        boolean eof = false;
        
        while (eof == false  && total < n) {
            int actualNum = read4(smallBuf); //to write 4 letters into newBuf
            if(actualNum < 4) eof = true;
            //write data into buf from smallBuf to buf
            int count = Math.min(actualNum, n-total);
            for(int i = 0; i < count; i++){
                buf[total] = smallBuf[i];
                total++;
            }
        }
        return total;
    }
}


//this is my own answer June 11 2019
/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    //the question is stupid because the read4 shouldn't use same buf parameter name
    //read4's buf is to save, the read buf is a final result, different things
    public int read(char[] buf, int n) {
        int result = 0;
        if(buf == null || n <= 0) return result;
        
        char[] tmp = new char[4];
        int oneRound = read4(tmp);
        while(oneRound == 4){
            for(int i = 0; i < oneRound; i++){
               if(result == n) return result; 
               buf[result++] = tmp[i];
            }
            oneRound = read4(tmp);
        }
        for(int i = 0; i < oneRound; i++){
            if(result == n) return result; 
            buf[result++] = tmp[i];
        }
        
        return result;
    }
}
