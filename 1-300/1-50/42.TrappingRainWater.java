42. Trapping Rain Water
Hard
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 
6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

Answer:
//https://www.youtube.com/watch?v=2LjNzbK2cmA&t=629s
//https://leetcode.com/problems/trapping-rain-water/solutions/153992/java-o-n-time-and-o-1-space-with-explanations/
class Solution {
    //就是当前单元能装多少水是取决于左右两边挡板最小值与当前值之差。之后就用双指针更新左右挡板就好了
    public int trap(int[] height) {
        int result = 0;
        if(height == null || height.length <= 1) return result;

        int start = 0;
        int end = height.length - 1;

        int leftMax = height[start];
        int rightMax = height[end];

        while(start < end){
            if(height[start] <= height[end]) {
                leftMax = Math.max(leftMax, height[start]);
                result += leftMax - height[start++];
            } else {
                rightMax = Math.max(rightMax, height[end]);
                result += rightMax - height[end--];
            }
        }

        return result;
    }
}
