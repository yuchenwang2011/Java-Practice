252. Meeting Rooms   My Submissions QuestionEditorial Solution
Total Accepted: 9807 Total Submissions: 23580 Difficulty: Easy
Given an array of meeting time intervals consisting of 
start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.

Answer:
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0) return true;
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        for(int i = 0; i < intervals.length - 1; i++){
            if(intervals[i][1] > intervals[i + 1][0]) return false;
        }
        
        return true;
    }
}
