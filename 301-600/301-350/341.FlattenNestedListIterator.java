341. Flatten Nested List Iterator   My Submissions QuestionEditorial Solution
Total Accepted: 2314 Total Submissions: 11958 Difficulty: Medium
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- 
whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false,
the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, 
the order of elements returned by next should be: [1,4,6].

Answer:
//My own idea
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
public class NestedIterator implements Iterator<Integer> {
    Queue<Integer> queue;
    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        helper(nestedList);
    }

    public void helper(List<NestedInteger> list){
        for(NestedInteger ni : list){
            if(ni.isInteger()) {
                queue.offer(ni.getInteger());
            } else {
                helper(ni.getList());
            }
        }
    }
    
    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

public class NestedIterator implements Iterator<Integer> {
    Deque<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        for(int i = nestedList.size() - 1; i >= 0; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            NestedInteger ni = stack.peek();
            if(ni.isInteger()) return true;
            
            stack.pop();
            List<NestedInteger> list = ni.getList();
            for(int i = list.size() - 1; i >= 0; i--){
                stack.push(list.get(i));
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
