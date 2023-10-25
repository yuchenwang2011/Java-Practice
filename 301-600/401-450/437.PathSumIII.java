437. Path Sum III
Medium 10.1K 476

Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

Example 1:
Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.

Example 2:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3

Constraints:
The number of nodes in the tree is in the range [0, 1000].
-109 <= Node.val <= 109
-1000 <= targetSum <= 1000

Accepted 484.4K Submissions 1M Acceptance Rate 47.3%

Answer:
//followed this link: https://www.jiakaobo.com/leetcode/437.%20Path%20Sum%20III.html
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        return (int)help(root, (long)targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private long help(TreeNode node, long targetSum) {
        if (node == null) return 0;

        return (node.val == targetSum ? 1 : 0)
        + help(node.left, targetSum - node.val)
        + help(node.right, targetSum - node.val);
    }
}

//https://leetcode.com/problems/path-sum-iii/solutions/1525060/easy-solution-using-java-dfs-map
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1); //for later in helper, when current == targetSum, plus 1
        return helper(root, map, 0, targetSum);
    }

    public int helper(TreeNode root, Map<Long, Integer> map, long current, int targetSum){
        if(root == null) {
            return 0;
        }

        current += root.val;
        int result = 0;
        result += map.getOrDefault(current - targetSum, 0);
        map.put(current, map.getOrDefault(current, 0) + 1);

        result += helper(root.left, map, current, targetSum);
        result += helper(root.right, map, current, targetSum);
        
        map.put(current, map.get(current) - 1);
        return result;
    }
}
