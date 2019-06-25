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

//in the below link, someone calculated the space complexity. I personally agree with him
//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/discuss/35220/My-Accepted-Java-Solution
// the time is O(n), since T(n) = 2T(n/2) + O(1).
// The space is O(logn) since there are at most logn recursion stacks in the meantime.
// Correct me if I am wrong.
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
