252. Meeting Rooms   My Submissions QuestionEditorial Solution
Total Accepted: 9807 Total Submissions: 23580 Difficulty: Easy
Given an array of meeting time intervals consisting of 
start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.

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
    //Got inspired by these 2 answers
    //********Remember the usage of Comparator!!!!
    //https://leetcode.com/discuss/50912/ac-clean-java-solution
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return true;
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){return a.start - b.start;}
        });
        
        for(int i = 0; i < intervals.length - 1; i++){
            if(intervals[i].end > intervals[i+1].start ) return false;
        }
        
        return true;
    }
}
