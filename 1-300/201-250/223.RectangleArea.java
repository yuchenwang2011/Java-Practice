223. Rectangle Area My Submissions QuestionEditorial Solution
Total Accepted: 33904 Total Submissions: 114471 Difficulty: Easy
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

https://leetcode.com/static/images/problemset/rectangle_area.png

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.

Answer:
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = 0;
        if(A > C || B > D || E > G || F > H) return sum;
        sum += (C - A) * (D - B);
        sum += (G - E) * (H - F);
        
        if(A >= G || B >= H || C <= E || D <= F) return sum;
        
        int length = Math.min(C,G) - Math.max(A,E);
        int width = Math.min(D,H) - Math.max(B,F);
        
        return sum - length * width;
    }
}
