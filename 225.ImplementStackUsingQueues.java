225. Implement Stack using Queues   My Submissions QuestionEditorial Solution
Total Accepted: 37296 Total Submissions: 122272 Difficulty: Easy
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, 
peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. 
You may simulate a queue by using a list or deque (double-ended queue), 
as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, 
no pop or top operations will be called on an empty stack).

Answer:
class MyStack {
    //There are also many good implementations, but I don't have time this round
    private Queue<Integer> queue = new LinkedList<Integer>();
    private Queue<Integer> tmpQueue = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        while(!queue.isEmpty()) tmpQueue.offer(queue.poll());
        queue.offer(x);
        while(!tmpQueue.isEmpty()) queue.offer(tmpQueue.poll());
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
