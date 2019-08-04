253. Meeting Rooms II   My Submissions QuestionEditorial Solution
Total Accepted: 10542 Total Submissions: 30437 Difficulty: Medium
Given an array of meeting time intervals consisting of start 
and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.

Answer:
//这题这么理解：start和end时间都打散了以后排序。
//凡是有一个start比end小，那就意味着需要一个屋子啊
//如果有两个start都比end小，那就更证明了有两个屋子时间上有冲突，就更需要两个屋子了
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int result = 0;
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0) return result;
        
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int end = 0;
        for(int i = 0; i < starts.length; i++){
            if(starts[i] < ends[end]) result++;
            else end++;
        }
        
        return result;
    }
}
