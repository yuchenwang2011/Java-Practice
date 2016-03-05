onvert Sorted Array to Binary Search Tree My Submissions Question
Total Accepted: 69475 Total Submissions: 189941 Difficulty: Medium
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

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
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int start = 0, end = nums.length-1;
        TreeNode root = process(nums,start,end);
        return root;
    }
    public TreeNode process(int[] nums, int start, int end){
        if(nums == null || nums.length == 0) return null;
        if(start > end) return null;
        if(start == end) return new TreeNode(nums[start]);
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = process(nums,start,mid-1);
        root.right = process(nums,mid+1, end);
        return root;
    }
}
