223. Rectangle Area My Submissions QuestionEditorial Solution
Total Accepted: 33904 Total Submissions: 114471 Difficulty: Easy
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

https://leetcode.com/static/images/problemset/rectangle_area.png

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.

Answer:
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //First add rec1's area, second add rec2's area, then delete the collapse area
        //Got inspired by this answer, when you want to do it in the silly way, it means you are wrong!!
        //https://leetcode.com/discuss/39188/an-easy-to-understand-solution-in-java
        int sum = 0;
        sum += (C - A) * (D - B);
        sum += (G - E) * (H - F);
        if(A >= G || E >= C || B >= H || F >= D) {   //when no overlap
            return sum;
        }
        
        int length = Math.min(C,G) - Math.max(A,E);
        int height = Math.min(D,H) - Math.max(B,F);
        
        return sum - length * height;
    }
}
