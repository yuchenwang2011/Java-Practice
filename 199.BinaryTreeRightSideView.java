199. Binary Tree Right Side View My Submissions Question
Total Accepted: 35480 Total Submissions: 106966 Difficulty: Medium
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

Credits:
Special thanks to @amrsaqr for adding this problem and creating all test cases.

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
//so this problem is equal to find the right most note of each level
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
                if(i == size-1) {
                    result.add(current.val);
                }
            }
        }
        return result;
    }
}

//Got inspired by this answer
//https://leetcode.com/discuss/85020/java-easy-solution-beats-90%25-using-dfs
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        dfs(root,result,0);
        return result;
    }
    public void dfs(TreeNode root, List<Integer> result, int level){
        if(root == null) return;
        if(level == result.size()) result.add(root.val);//0 level, size is 0; 1 level, size is 1; 2nd level, size is 2;
        //so size and level each time increase 1 at the same time
        //first right, if right null, then left
        dfs(root.right, result, level+1);
        dfs(root.left,result, level+1);
    }
}
