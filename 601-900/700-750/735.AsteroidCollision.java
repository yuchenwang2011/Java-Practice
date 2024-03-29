735. Asteroid Collision
Medium 7K 747

We are given an array asteroids of integers representing asteroids in a row.
For each asteroid, the absolute value represents its size, and the sign represents 
 its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. 
If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:
Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:
Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:
Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 
Constraints:
2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
Accepted 381.7K Submissions 839.9K Acceptance Rate 45.4%

Answer:
//from comment of https://leetcode.com/problems/asteroid-collision/solutions/109694/java-c-clean-code/
 class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length <= 1) return asteroids;

        Stack<Integer> stack = new Stack<>();
        for (int cur : asteroids) {
            if (cur > 0) { // *+: previous one does not matter, no collision forever
                stack.push(cur);
            } else {
                //+-
                while (!stack.isEmpty() && stack.peek() > 0 && -cur > stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(cur); // --
                } else if (stack.peek() == -cur) {
                    stack.pop(); // +- size same
                }
            }
        }
        return stack.stream().mapToInt(i->i).toArray();
    }
}
