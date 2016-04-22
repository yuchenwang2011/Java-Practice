155. Min Stack   My Submissions QuestionEditorial Solution
Total Accepted: 69527 Total Submissions: 316232 Difficulty: Easy
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Answer:
class MinStack {
    //Got inspired by this answer
    //https://leetcode.com/discuss/21071/java-accepted-solution-using-one-stack
    
    private Deque<Integer> stack = new ArrayDeque<Integer>();
    private int min = Integer.MAX_VALUE;
    
    public void push(int x) {
        if(x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.peek() == min) {
            stack.pop();
            min = stack.peek();
        }
        stack.pop();
        if(stack.isEmpty()) min = Integer.MAX_VALUE;
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

