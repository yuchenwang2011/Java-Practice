109. Convert Sorted List to Binary Search Tree   My Submissions QuestionEditorial Solution
Total Accepted: 68950 Total Submissions: 226684 Difficulty: Medium
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

Answer:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    //These 2 answers are similar to my idea
    //https://leetcode.com/discuss/42477/share-my-easy-understatnd-java-solution
    //https://leetcode.com/discuss/83856/share-my-java-solution-1ms-very-short-and-concise
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return process(head);
    }
    
    public TreeNode process(ListNode head){
        TreeNode root = null;
        if(head == null) return root;
        ListNode preFirst = null;
        ListNode first = head;
        ListNode second = head.next;
        while(second != null && second.next != null) { //1, 2, 3, 4 first = 2; 1,2,3,4,5 first = 3
            preFirst = first;
            first = first.next;
            second = second.next.next;
        }
        second = first.next;
        if(preFirst != null) preFirst.next = null;
        else head = null; //because first = head is already used.
        root = new TreeNode(first.val);
        root.left = process(head);
        root.right = process(second);
        return root;
    }
}
