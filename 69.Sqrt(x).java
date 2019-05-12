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
    //Got inspired by this answer and the following replies
    //https://leetcode.com/discuss/8897/share-my-o-log-n-solution-using-bit-manipulation
    public int mySqrt(int x) {
        long bit = 1L << 16; //because bit ^2 needs to smaller than Integer.MAX_VALUE;
        long result = 0;
        while(bit > 0){
            result = result | bit; //bit can't be zero, if zero, here is useless
            //it's not the 1L << 0, it's bit == 0, bit can be 1L << 1
            if(result * result > x) result = result ^ bit; //cancel this bit
            bit = bit >> 1; //try next bit; here also bit can't be zero, 0 >> 1 = 0
        }
        return (int) result;
    }
}
