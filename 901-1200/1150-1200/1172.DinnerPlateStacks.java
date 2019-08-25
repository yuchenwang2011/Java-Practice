1172. Dinner Plate Stacks
Hard

2

0

Favorite

Share
You have an infinite number of stacks arranged in a row and numbered (left to right) from 0, each of the stacks has the same maximum capacity.

Implement the DinnerPlates class:

DinnerPlates(int capacity) Initializes the object with the maximum capacity of the stacks.
void push(int val) pushes the given positive integer val into the leftmost stack with size less than capacity.
int pop() returns the value at the top of the rightmost non-empty stack and removes it from that stack, and returns -1 if all stacks are empty.
int popAtStack(int index) returns the value at the top of the stack with the given index and removes it from that stack, and returns -1 if the stack with that given index is empty.
Example:

Input: 
["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
[[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
Output: 
[null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]

Explanation: 
DinnerPlates D = DinnerPlates(2);  // Initialize with capacity = 2
D.push(1);
D.push(2);
D.push(3);
D.push(4);
D.push(5);         // The stacks are now:  2  4
                                           1  3  5
                                           ﹈ ﹈ ﹈
D.popAtStack(0);   // Returns 2.  The stacks are now:     4
                                                       1  3  5
                                                       ﹈ ﹈ ﹈
D.push(20);        // The stacks are now: 20  4
                                           1  3  5
                                           ﹈ ﹈ ﹈
D.push(21);        // The stacks are now: 20  4 21
                                           1  3  5
                                           ﹈ ﹈ ﹈
D.popAtStack(0);   // Returns 20.  The stacks are now:     4 21
                                                        1  3  5
                                                        ﹈ ﹈ ﹈
D.popAtStack(2);   // Returns 21.  The stacks are now:     4
                                                        1  3  5
                                                        ﹈ ﹈ ﹈ 
D.pop()            // Returns 5.  The stacks are now:      4
                                                        1  3 
                                                        ﹈ ﹈  
D.pop()            // Returns 4.  The stacks are now:   1  3 
                                                        ﹈ ﹈   
D.pop()            // Returns 3.  The stacks are now:   1 
                                                        ﹈   
D.pop()            // Returns 1.  There are no stacks.
D.pop()            // Returns -1.  There are still no stacks.
 

Constraints:
1 <= capacity <= 20000
1 <= val <= 20000
0 <= index <= 100000
At most 200000 calls will be made to push, pop, and popAtStack.

Accepted 371 Submissions 1,289

Hint:
1. Use a data structure to save the plate status. 
You may need to operate the exact index. 
Maintain the leftmost vacant stack and the rightmost non-empty stack.

2. Use a list of stack to store the plate status. 
Use heap to maintain the leftmost and rightmost valid stack.

Answer
//我比赛151自己的解答，答案应该是对的，但是超时了
class DinnerPlates {
    List<Stack<Integer>> stacks;
    int capacity;
    public DinnerPlates(int capacity) {
        stacks = new ArrayList<>();
        this.capacity = capacity;
    }
    
    public void push(int val) {
        for(int i = 0; i < stacks.size(); i++){
            Stack<Integer> stack = stacks.get(i);
            if(stack.size() < capacity) {
                stack.push(val);
                return;
            }
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(val);
        stacks.add(stack);
    }
    
    public int pop() {
        int result = -1;
        int size = stacks.size();
        if(size == 0) return result;
        
        if(size != 0){
            Stack<Integer> stack = stacks.get(size - 1);
            if(!stack.isEmpty()) result = stack.pop();
            if(stack.isEmpty()){
                stacks.remove(stacks.size() - 1);
            }
        }
        return result;
    }
    
    public int popAtStack(int index) {
        int result = -1;
        int size = stacks.size();
        if(size == 0 || index < 0 || index >= size) return result;
        Stack<Integer> stack = stacks.get(index);
        if(!stack.isEmpty()) result = stack.pop();
        if(index == size - 1 && stack.isEmpty()) stacks.remove(index);
        return result;
    }
}
