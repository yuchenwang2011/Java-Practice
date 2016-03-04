255. Verify Preorder Sequence in Binary Search Tree My Submissions Question
Total Accepted: 6408 Total Submissions: 17584 Difficulty: Medium
Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Follow up:
Could you do it using only constant space complexity?

Answer:
//This is BST, so [5,3,2,4,7,6,8]     , is the preorder of [5,3,7,2,4,6,8]
//This is from method 1 from this link
//https://leetcode.com/discuss/51543/java-o-n-and-o-1-extra-space
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder.length == 0) return true;
        int low = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for(int i = 0; i < preorder.length; i++){
            if(preorder[i] < low) return false;
            //the stack.peek is to get the first element of the stack on the top, so [5,3,2,4,7] is 2,3,4,5 when i=3/4
            while(!stack.isEmpty() && preorder[i] > stack.peek()) {
                System.out.println(i + " " + stack.peek());
                low = stack.pop();
            }
            stack.push(preorder[i]);
        }
        return true;
    }
}

public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder.length == 0) return true;
        int low = Integer.MIN_VALUE; 
        int stackSize = -1;
        for(int p : preorder){
            if(p < low) return false;
            while(stackSize >= 0 && p > preorder[stackSize]){
                low = preorder[stackSize];
                stackSize--;
            }
            stackSize++;
            preorder[stackSize] = p;
        }
        return true;
    }
}
