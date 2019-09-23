84. Largest Rectangle in Histogram
Hard
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.

Example: 
Input: [2,1,5,6,2,3]
Output: 10

Answer:
Some dicussion help to understand this question
I would like to explain i - 1 - stack.peek() in this way:

Let's take the second bar(2) as the example. bar(2) means the bar with height = 2.

When i is at bar(2), the top in stack is bar(6). If we take bar(6) as the current height of the rectangle, 
we need to find the left and right boundary bar of the rectangle. 
It is always true that both left and right boundary bar has a height either equal or larger than bar(6).

Right Boundary: bar(2), which i points to now, is the first bar that is lower than bar(6) on its right, 
so the right boundary is (i - 1).
Left Boundary: bar(5), which is the top in stack after bar(6) is popped, 
is the first bar that is lower than bar(6) on its left, so the left boundary is (stack.peek() + 1).

Now we have found both left and right boundaries, then let's get the width of the rectangle. 
The width = index of right boundary - index of left boundary + 1 = (i - 1) - (stack.peek() + 1) + 1 = i - 1 - stack.peek().
Then the area = (height of bar(6)) * (i - 1 - stack.peek()).

Let's move to the next loop. The top in stack now is bar(5), and i points to bar(2). 
So we pop bar(5) out from the stack and take bar(5)'s height as the rectangle's height.

Right Boundary: bar(2) is the first bar that is lower than bar(5) on its right. Then the right boundary is (i - 1).
Left Boundary: bar(1), which is the top in stack after bar(5) is popped, 
is the first bar that is lower than bar(5) on its left. So the left boundary is (stack.peek() + 1).

The width = (i - 1) - (stack.peek() + 1) = i - 1 - stack.peek() and area = (height of bar(5)) * (i - 1 - stack.peek())).

There is only bar(1) left in the stack, and it is lower than bar(2),
which i points to now. So we continue pushing bars to stack till the height 
starts to decrease or the end of the histogram. 
Now the stack has bar(1), bar(2), bar(3) and bar(3) is on the top. 
i points to the position on the right of bar(3).

We pop bar(3) out of the stack and take its height as the rectangle's height. 
The right boundary is (i - 1); the left boundary is bar(2) which is (stack.peek() + 1).

Next, pop bar(2) out of the stack and take its height as the rectangle's height. 
Remember that the boundary's height is either equal or larger than bar(2)'s height. 
The right boundary is bar(3), which is (i - 1). The left boundary is bar(1)'s right which is (stack.peek() + 1).

What if the stack is empty when looking for the left boundary?
Let's take the example when stack contains bar(1) only. 
It's obvious that the right boundary is (i - 1). After popping bar(1) out,
the stack is empty. It means there is no bar that is lower than bar(1) on its left.
So the left boundary is all the way to the left, which is the most left of the histogram with index = 0. 
Then the width = (i - 1) - 0 + 1 = i. The area = (height of bar(1)) * i.

So the idea is that:

1For each bar, take its height as the rectangle's height. Then find the left and right boundaries of this rectangle.
2(The second top bar in stack) is always the first bar lower than (the top bar in stack) on the left.
3(The bar that i points to) is always the first bar lower than (the top bar in stack) on the right.
4After step 2 and 3, we know the left and right boundaries, then know the width, then know the area.

//第二遍复习我觉得思路就是简单的，
//因为我们求最大面积嘛，所以一个一个height往stack放，如果当前height没有之前那个大
//那就说明前面那个大，就有算一下他面积的必要.于是就开始高乘以长
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        if(heights == null || heights.length == 0) return maxArea;
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        //Alert: here you must use <= 
        for(int i = 0; i <= heights.length; i++){
            int currentHeight = i == heights.length ? 0 : heights[i];
            
            while(!stack.isEmpty() && currentHeight < heights[stack.peek()]){
                int top = stack.pop();
                //当初觉得这里很难，其实很简单
                //stack不空:因为循环到i的时候，i实际上是current的位置啊，所以前一个height的位置肯定是i - 1啊
                //i - 1的前一个，就是stack的peek，比如一个4，一个3，4-3=1嘛
                
                //然后stack空的时候，就是height值们4,3,2,1各种递减的时候，所以没存下来都pop走了
                //所以现在是1，我们一直在算前一个长条的宽，也就是2的宽。就是3一直到最左边嘛，就是2 + 1 = 3，恰好是1的位置而已
                int length = stack.isEmpty() ? i : i - 1 - stack.peek();
                maxArea = Math.max(maxArea, heights[top] * length);
            }
            
            stack.push(i);
        }
        
        return maxArea;
    }
}
