275. H-Index II My Submissions QuestionEditorial Solution
Total Accepted: 21522 Total Submissions: 66257 Difficulty: Medium
Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.

Answer:
//这题和274的第一个慢的解法一样，先研究研究那个
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int start = 0;
        int end = citations.length - 1;
        int n = citations.length;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(citations[mid] == n - mid) return n - mid;
            else if (citations[mid] < n - mid) start = mid;
            else end = mid;
        }
        if(citations[start] >= n - start) return n - start;
        if(citations[end] >= n - end) return n - end;
        return 0;
    }
}
