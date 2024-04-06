56. Merge Intervals
Given a collection of intervals, merge all overlapping intervals.
Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

Answer:
//这个和下一题的风格是一样的
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0].length < 2) return new int[0][0];
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] tmp = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int[] cur = intervals[i];
            //a |________|
            //b   |__|
            if(tmp[1] >= cur[1]){
                continue;
            //a |___|
            //b   |____|
            } else if(tmp[1] > cur[0]){
                tmp[1] = cur[1];
            } else {
            //a |___|
            //b        |____|
                result.add(tmp);
                tmp = cur;
            }
        }
        result.add(tmp);
        int[][] resultArray = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++){
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}
