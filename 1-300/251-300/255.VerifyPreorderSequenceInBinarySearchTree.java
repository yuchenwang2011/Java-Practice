255. Verify Preorder Sequence in Binary Search Tree
Medium

Given an array of numbers, verify whether 
it is the correct preorder traversal sequence of a binary search tree.
You may assume each number in the sequence is unique.
Consider the following binary search tree: 

     5
    / \
   2   6
  / \
 1   3
         
Example 1:
Input: [5,2,6,1,3]
Output: false
    
Example 2:
Input: [5,2,1,3,6]
Output: true
    
Follow up:
Could you do it using only constant space complexity?
    
Answer:
//第一个解法是用stack，第二个是升级版直接在原来的input数组上开练
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) return true;
        int min = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int num : preorder){
            if(num < min) return false;
            while(!stack.isEmpty() && num > stack.peek()){
                min = stack.pop();
            }
            stack.push(num);
        }
        return true;
    }
}

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) return true;
        
        int i = -1;
        int min = Integer.MIN_VALUE;
        for(int num : preorder){
            if(num < min) return false;
            while(i >= 0 && num > preorder[i]){
                min = preorder[i--];
            }
            preorder[++i] = num;
        }
        return true;
    }
}
