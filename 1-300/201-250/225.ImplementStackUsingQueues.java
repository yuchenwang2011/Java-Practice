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
//第一个方法是新的，用一个queue，更好一些。
//第二个方法是当年的好理解的，用两个queue，倒来倒去
class MyStack {
    Queue<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.offer(x);
        int size = queue.size() - 1;
        for(int i = 0; i < size; i++){
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}


class MyStack {
    private Queue<Integer> queue = new LinkedList<Integer>();
    private Queue<Integer> tmpQueue = new LinkedList<Integer>();
    
    public void push(int x) {
        while(!queue.isEmpty()) tmpQueue.offer(queue.poll());
        queue.offer(x);
        while(!tmpQueue.isEmpty()) queue.offer(tmpQueue.poll());
    }
    public void pop() {
        queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
