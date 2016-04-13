275. H-Index II My Submissions QuestionEditorial Solution
Total Accepted: 21522 Total Submissions: 66257 Difficulty: Medium
Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.

Answer:
public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int start = 0, end = citations.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(citations[mid] == citations.length - mid) return citations.length - mid;
            else if (citations[mid] > citations.length - mid) end = mid;
            else start = mid;
        }
        if(citations[start] >= citations.length - start) return citations.length - start;
        if(citations[end] >= citations.length - end) return citations.length - end;
        return 0;
    }
}
