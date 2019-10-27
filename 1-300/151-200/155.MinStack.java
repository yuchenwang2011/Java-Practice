155. Min Stack   My Submissions QuestionEditorial Solution
Total Accepted: 69527 Total Submissions: 316232 Difficulty: Easy
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Answer:
//一道题怎么会想到用stack呢？就是你从左往右撸的时候，你还总得往回看
//需要一个东西记录一下左边的东西当内存用。这个时候就得用stack
//做这个题之前，顺便写一个stack的其他相关题目,因为不知道记在哪里
how to sort using stack？ 

public static void stackSorting(Stack<Integer> stack) {
 Stack<Integer> t = new Stack<>();
  while(!stack.isEmpty()) {
        int item = stack.pop();
        while(!t.isEmpty() && t.peek() > item) stack.push(t.pop());
        t.push(item);   
  }   
  while(!t.isEmpty()) stack.push(t.pop());
}

class MinStack {
    private int min;
    private Deque<Integer> stack;
    
    public MinStack() {
        stack = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        int val = stack.pop();
        if(val == min) {
            min = stack.pop();
        }
        //判断是否为空其实不需要
        //if(stack.isEmpty()) min = Integer.MAX_VALUE;
    }
    
    public int top() {
        //判断是否为空其实不需要
        //if(stack.isEmpty()) return min;
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

//大神级思路
class MinStack {
    class Node{
        int val;
        int min;
        Node next;
        public Node(int val, int min){
            this.val = val;
            this.min = min;
            this.next = null;
        }
    }
    
    private Node head;
    
    public MinStack() {
        head = null;
    }
    
    public void push(int x) {
        if(head == null) {
            head = new Node(x, x);
        } else {
            Node node = new Node(x, Math.min(x, head.min));
            node.next = head;
            head = node;
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}
