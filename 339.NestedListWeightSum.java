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
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    //https://leetcode.com/discuss/94956/2ms-easy-to-understand-java-solution
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) return 0;
        long[] result = new long[1]; 
        result[0] = 0; 
        process(nestedList, result, 1);
        if(result[0] > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(result[0] < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) result[0];
    }
    
    public void process(List<NestedInteger> list , long[] result, int depth){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).isInteger()) result[0] += depth * list.get(i).getInteger();
            else process(list.get(i).getList(), result, depth + 1);
        }
    }
}
