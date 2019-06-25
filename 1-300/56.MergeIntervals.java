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
//my own solution
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0].length < 2) return intervals;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++){
            int[] a = result.get(result.size() - 1);
            int[] b = intervals[i];
            //a |________|
            //b   |__|
            //alert: they are all integers, so must <= or >=
            if(a[0] <= b[0] && a[1] >= b[1]) {
                continue;   
            } else if (a[1] >= b[0]){
                //a |___|
                //b   |____|
                a[1] = b[1];
            } else {
                //a |___|
                //b        |____|
                result.add(b);
            }
        }
        
        int[][] resultArray = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++){
            resultArray[i] = result.get(i);
        }
        
        return resultArray;
    }
}
