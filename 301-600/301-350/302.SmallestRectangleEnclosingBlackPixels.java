302. Smallest Rectangle Enclosing Black Pixels
Hard

An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. 
The black pixels are connected, i.e., there is only one black region. 
Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, 
return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

Example:
Input:
[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2
Output: 6

Accepted 24,758 Submissions 49,318

Answer:
//O(mlogn + nlogm)
//用binary search找出左边和右边那个点，which在那行那列上有1的
class Solution {
    public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0 || image[0].length == 0) return 0;
        int row = image.length;
        int col = image[0].length;
        
        int left = leftMost(image, 0, y, true);
        int right = rightMost(image, y, col - 1, true);
        int up = leftMost(image, 0, x, false);
        int down = rightMost(image, x, row - 1, false);
        return (right - left + 1) * (down - up + 1);
    }
    
    public int leftMost(char[][] image, int start, int end, boolean isHorizon){
        //if(start >= end) return start;
        while(start + 1 < end){
            int mid = (end - start) / 2 + start;
            if(hasBlack(image, mid, isHorizon)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(hasBlack(image, start, isHorizon)) return start;
        return end;
    }
    
    public int rightMost(char[][] image, int start, int end, boolean isHorizon){
        //if(start >= end) return start;
        while(start + 1 < end){
            int mid = (end - start) / 2 + start;
            if(hasBlack(image, mid, isHorizon)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(hasBlack(image, end, isHorizon)) return end;
        return start;
    }
    
    public boolean hasBlack(char[][] image, int x, boolean isHorizon){
        if(isHorizon) {
            //竖着查
            for(int i = 0; i < image.length; i++){
                if(image[i][x] == '1') return true;
            }
            return false;
        } else {
            //横着查
            for(int i = 0; i < image[0].length; i++){
                if(image[x][i] == '1') return true;
            }
            return false;
        }
    }
}
