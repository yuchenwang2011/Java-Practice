218. The Skyline Problem
Hard

A city's skyline is the outer contour of the silhouette formed 
by all the buildings in that city when viewed from a distance. 
Now suppose you are given the locations and height of all the buildings 
as shown on a cityscape photo (Figure A), write a program to output the skyline 
formed by these buildings collectively (Figure B).
https://leetcode.com/problems/the-skyline-problem/

Buildings  Skyline Contour
The geometric information of each building is represented
by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates 
of the left and right edge of the ith building, respectively, and Hi is its height. 
It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. 
You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: 
[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of 
[ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. 
A key point is the left endpoint of a horizontal line segment. 
Note that the last key point, where the rightmost building ends, 
is merely used to mark the termination of the skyline, and always has zero height.
Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:
[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:
The number of buildings in any input list is guaranteed to be in the range [0, 10000].
The input list is already sorted in ascending order by the left x position Li.
The output list must be sorted by the x position.
There must be no consecutive horizontal lines of equal height in the output skyline. 
For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; 
the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]

Answer:
//this is the best video https://www.youtube.com/watch?v=GSBLe8cKu0s
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b:buildings) {
            //这里就是用了一个小技巧区分一下起始点和终结点
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        //alert: a - b, test case: [0,2,3],[2,5,3]  or [[0,4],[5,0]]
        //这里是为了如果两个点x一样，意味着重叠了。反正简而言之就是就是小的放前面
        //如果是一个起始点和一个终结点。a[1]-b[1]就是先放入起始点
        //或者如果是两个都是起始点，就是都是负值，小的负值其实反而更高，覆盖了另外一个。
        //或者如果是两个都是终结点，两个都是正值，俩其实都没啥用。他俩前面的那个点肯定是用高的这组的高，如果不把小的放前面，后面的pre cur就没法换了
        Collections.sort(height, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        //pq要大的放前面，因为要看peek第一个值，因为最大值变了，就是我们要找的点
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);
        int prev = 0;
        for(int[] h:height) {
            if(h[1] < 0) {
                //小于零，代表着这个数是起点啊，起点就意味着这个高度还没有进过pq
                pq.offer(-h[1]);
            } else {
                //大于零，代表这个数是终点，也就是这个高度值曾经进过pq，我们用完了就不要了
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            //这里就是说，一旦cur和pre不一样，也就是高度有变化了，就需要把点放进result里
            if(prev != cur) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(h[0]);
                tmp.add(cur);
                result.add(tmp);
                prev = cur;
            }
        }
        return result;
    }
}
