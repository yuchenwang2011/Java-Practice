296. Best Meeting Point
Hard

A group of two or more people wants to meet and minimize the total travel distance. 
You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. 
The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

Example:
Input: 

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

Output: 6 

Explanation: Given three people living at (0,0), (0,4), and (2,2):
             The point (0,2) is an ideal meeting point, as the total travel distance 
             of 2+2+2=6 is minimal. So return 6.
             
Accepted 26,784 Submissions 48,215

Answer:
class Solution {
    public int minTotalDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        List<Integer> rowList = new ArrayList<>();
        List<Integer> colList = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) {
                    rowList.add(i);
                }
            }
        }

        //这里这样做是为了加进两个list的值都是有序的
        //第一个大循环就是一横条一横条的扫，所以加进去的row值是从小到大的
        //第二个大循环就是一竖条一竖条的扫，所以家进入的col值是从小到大的
        for(int i = 0; i < grid[0].length; i++){
            for(int j = 0; j < grid.length; j++){
                if(grid[j][i] == 1) {
                    colList.add(i);
                }
            }
        }
        return getMin(rowList) + getMin(colList);
    }

    public int getMin(List<Integer> list){
        if(list == null || list.size() == 0) return 0;
        int start = 0;
        int end = list.size() - 1;
        int result = 0;
        while(start < end){
            result += list.get(end--) - list.get(start++);
        }
        return result;
    }
}
