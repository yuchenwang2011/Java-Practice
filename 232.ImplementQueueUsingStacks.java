232. Implement Queue using Stacks   My Submissions QuestionEditorial Solution
Total Accepted: 41008 Total Submissions: 120914 Difficulty: Easy
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, 
peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. 
You may simulate a stack by using a list or deque (double-ended queue), 
as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, 
no pop or peek operations will be called on an empty queue).

Answer:
class MyQueue {
    //Got inspired by this answer
    //https://leetcode.com/discuss/67154/easy-java-solution-just-edit-push-method
    private Deque<Integer> stack = new ArrayDeque<Integer>();
    private Deque<Integer> tmpStack = new ArrayDeque<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        while(stack.size() != 0) tmpStack.push(stack.pop());
        stack.push(x);
        while(tmpStack.size() != 0) stack.push(tmpStack.pop());
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
