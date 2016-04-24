253. Meeting Rooms II   My Submissions QuestionEditorial Solution
Total Accepted: 10542 Total Submissions: 30437 Difficulty: Medium
Given an array of meeting time intervals consisting of start 
and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.

Answer:
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    //Got inspired by this answer: think very hard to understand, just read the explanation 3 times
    //https://leetcode.com/discuss/82292/explanation-super-easy-java-solution-beats-from-%40pinkfloyda
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        int[] start = new int[intervals.length];
        int[] end   = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            start[i] = intervals[i].start;
              end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        int rooms = 0;
        int endPos = 0;
        for(int i = 0; i < intervals.length; i++){
            if(start[i] < end[endPos]) rooms++;
            else  endPos ++;
        }
        return rooms;
     }
}
