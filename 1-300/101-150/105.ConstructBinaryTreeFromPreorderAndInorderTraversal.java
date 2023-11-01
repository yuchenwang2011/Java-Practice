105. Construct Binary Tree from Preorder and Inorder Traversal My Submissions Question
Total Accepted: 57953 Total Submissions: 205998 Difficulty: Medium
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

Answer:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//记牢一个口诀，就是pre in post的这些order，都指的是"root"(重音！重音！重音！)的order，root分别在pre，inside，post的时候才会被遍历
//pre，就是先从root开始撸，然后撸左右
//In就是root在中间被撸，也就是先撸左边，再撸root，再撸右边
//post就是先撸左右，再撸root。wikipedia上的例子图很好，其他网上的很多都是错的
//https://en.wikipedia.org/wiki/Tree_traversal


// The basic idea is here:
// Say we have 2 arrays, PRE and IN.
// Preorder traversing implies that PRE[0] is the root node.
// Then we can find this PRE[0] in IN, say it's IN[5].
// Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
// Recursively doing this on subarrays, we can build a tree out of it :)

//Got inspired by this Indian video, which uses test cases as follow
//https://www.youtube.com/watch?v=PAYG5WEC1Gs
//https://leetcode.com/discuss/12179/my-accepted-java-solution
//Inorder: [15,30,35,40,45,50,60,70,72,75,77,80]
//Preorder: [50,30,15,40,35,45,70,60,80,75,72,77]
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length) return null;
        return construct(0,0,inorder.length-1,preorder,inorder);
    }
    
    public TreeNode construct(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        if(preStart > preorder.length - 1 || inStart > inEnd ) return null; //这行必须的
        int inRoot = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(preorder[preStart] == inorder[i]) {
                inRoot = i;
            }
        }
        TreeNode root = new TreeNode(preorder[preStart]); //inorder[inRoot]也行
        root.left = construct(preStart+1, inStart, inRoot-1, preorder, inorder);
        //As for why preStart must go to the other side? Why all elements before that are in left tree?
        //Because preorder is to root first, left elements first, then right. So length of all left elements 
        //must be the same as the inorder left elements length
        int length = inRoot - inStart; 
        root.right = construct(preStart + inLength + 1, inRoot + 1, inEnd, preorder, inorder);
        return root;
    }
}
