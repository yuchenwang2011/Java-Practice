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
//https://leetcode.com/problems/path-sum-iii/solutions/91889/simple-java-dfs/
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

//from the comment of https://leetcode.com/problems/path-sum-iii/solutions/91878/17-ms-o-n-java-prefix-sum-method/
//The map stores the frequency of all possible sum in the path to the current node.
//If the difference between the current sum and the target value exists in the map, there must exist a node in the middle of the path, 
//such that from this node to the current node, the sum is equal to the target value.
//举个例子，从1->2->3, current = 6, target = 5; 如果map里包括了现在current - target = 1的值，那么也就是说，从存了那个值的点，那个点到现在这个点，加起来等于target
//所以有多少路到那个点，就result多出那么多选择
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
        //这里为什么是current被减而不是反过来呢，因为current是so far所有的node的和，
        //current - target是想看看之前的current值们有没有可能被收录过，反过来target被减是没有意义的
        int result = map.getOrDefault(current - targetSum, 0);
        map.put(current, map.getOrDefault(current, 0) + 1);

        result += helper(root.left, map, current, targetSum);
        result += helper(root.right, map, current, targetSum);
        
        map.put(current, map.get(current) - 1);
        return result;
    }
}
