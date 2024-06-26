339. Nested List Weight Sum   My Submissions QuestionEditorial Solution
Total Accepted: 1885 Total Submissions: 3471 Difficulty: Easy
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

Example 2:
Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)

Answer:
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
//https://leetcode.com/problems/nested-list-weight-sum/solutions/79957/2ms-easy-to-understand-java-solution/
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) return 0;
        return helper(nestedList, 1);
    }
    
    public int helper(List<NestedInteger> list, int level){
        int result = 0;
        for(NestedInteger ni : list){
            if(ni.isInteger()) {
                result += ni.getInteger() * level;
            } else {
                result += helper(ni.getList(), level + 1);
            }
        }
        return result;
    }
}

//https://leetcode.com/problems/nested-list-weight-sum/solutions/79933/java-solution-similar-to-tree-level-order-traversal/                                            
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) return 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        for(NestedInteger ni : nestedList){
            queue.offer(ni);
        }
        
        int result = 0;
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                NestedInteger tmp = queue.poll();
                if(tmp.isInteger()) result += tmp.getInteger() * level;
                else {
                    queue.addAll(tmp.getList());
                }
            }
            level++;
        }
        return result;
    }
}
