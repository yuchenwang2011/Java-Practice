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
