69. Sqrt(x) My Submissions QuestionEditorial Solution
Total Accepted: 89912 Total Submissions: 357699 Difficulty: Medium
Implement int sqrt(int x).

Compute and return the square root of x.

Answer:
public class Solution {
    public int mySqrt(int x) {
        if(x <= 0) return x;
        int start = 1, end = x;
        while(start < end){
            int mid = start + (end - start)/2;
            if(mid == x / mid || mid < x/mid && (mid + 1) > x / (mid+1)) return mid;
            else if (mid < x / mid) start = mid + 1;
            else end = mid; //it's both ok here end = mid or end = mid -1;
        }
        return start;
    }
}
//this is using template, use this one
class Solution {
    public int mySqrt(int x) {
        if(x <= 0) return x;
        int start = 1;
        int end = x;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(mid == x / mid) return mid;
            else if(mid < x / mid){
                start = mid;
            } else {
                end = mid;
            }
        }
        if(start < x / start && end > x / end) return start;
        return end;
    }
}

//我感觉这么记忆，牛顿喝多了，先拿了很大一个数，然后呢就开始往回找补
//怎么的都得是处理r啊，先把r变大一点点，然后除以2变小一点点。
//就这么不断的变大一点点，然后变小一点点，就对了
//至于r + x /r 怎么记，就记x是比较大的，x除以r就能在变大一点点的过程中大一点
//不然除以2变小的过程太快了
public class Solution {
    //This answer uses Newton's method, but i don't think I can remember this
    //Inspired by this answer:
    //https://leetcode.com/discuss/58631/3-4-short-lines-integer-newton-every-language
    public int mySqrt(int x) {
        long r = x;
        while(r * r > x){
            r = (r + x/r) / 2; 
        }
        return (int) r;
    }
}

public class Solution {
    //To understand this solution, try a big number, and print out the result value in binary
    //就是先从最大可能的一位开始撸，如果太大了，就不要了算了从下一个位撸。还是大就再取消，再试下一位
    //突然有一次，哎，咋太小了呢，说明这回第一位是对了。那就从下一位开始重复操作。
    //Got inspired by this answer and the following replies
    //https://leetcode.com/discuss/8897/share-my-o-log-n-solution-using-bit-manipulation
    public int mySqrt(int x) {
        long bit = 1L << 16; //because bit ^2 needs to smaller than Integer.MAX_VALUE;
        int result = 0;
        while(bit > 0){
            result = result | bit; //bit can't be zero, if zero, here is useless
            System.out.println(Integer.toBinaryString(result));
            //it's not the 1L << 0, it's bit == 0, bit can be 1L << 1
            if(result > x / result) result = result ^ bit; //cancel this bit
            bit = bit >> 1; //try next bit; here also bit can't be zero, 0 >> 1 = 0
        }
        return (int) result;
    }
}
