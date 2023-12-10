733. Flood Fill
Easy 8K 790

An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, 
plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. 
Replace the color of all of the aforementioned pixels with color.
Return the modified image after performing the flood fill.

Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), 
all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

Example 2:
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation: The starting pixel is already colored 0, so no changes are made to the image.
 
Constraints:
m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], color < 216
0 <= sr < m
0 <= sc < n
Accepted 813.2K Submissions 1.3M Acceptance Rate 63.2%

Answer:
 //all my own solutions
//BFS same as question 200
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[0].length == 0) return image;
        if(image[sr][sc] == color) return image; //this line is necessary to submit successfully
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        int initialColor = image[sr][sc];
        image[sr][sc] = color;

        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] tmp = queue.poll();
                int x = tmp[0];
                int y = tmp[1];
                for(int[] direction: directions){
                    int row = x + direction[0];
                    int col = y + direction[1];

                    if(row < 0 || col < 0 || row >= image.length 
                    || col >= image[0].length
                    || image[row][col] != initialColor) continue;

                    queue.offer(new int[]{row, col});
                    image[row][col] = color;
                }
            }
        }
        return image;
    }
}

//DFS same as question 200
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[0].length == 0) return image;
        if(image[sr][sc] == color) return image;
        int initialColor = image[sr][sc];

        helper(image, sr, sc, color, initialColor);
        return image;
    }

    public void helper(int[][] image, int sr, int sc, int color, int initialColor){
        if(sr < 0 || sr >= image.length ||
            sc < 0 || sc >= image[0].length || image[sr][sc] != initialColor) return;
        image[sr][sc] = color;

        helper(image, sr - 1, sc, color, initialColor);
        helper(image, sr + 1, sc, color, initialColor);
        helper(image, sr, sc - 1, color, initialColor);
        helper(image, sr, sc + 1, color, initialColor);
    }
}
