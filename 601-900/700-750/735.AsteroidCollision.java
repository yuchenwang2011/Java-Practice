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
//my own solution
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids == null || asteroids.length == 0) return new int[0];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            int current = asteroids[i];
            if (i == 0 || stack.size() == 0) {
                stack.push(current);
                continue;
            } 

            while(stack.size() > 0){
                int last = stack.peek();
                if((last > 0 && current > 0) 
                    || (last < 0 && current < 0) 
                    || (last == 0 && current == 0)
                    || (last <= 0 && current > 0)){
                    stack.push(current);
                    break;
                }

                if(Math.abs(current) > Math.abs(last)) {
                    if(stack.size() > 0) {
                        stack.pop();
                        if(stack.size() == 0){
                            stack.push(current);
                            break;
                        }
                    } else {
                        stack.push(current);
                        break;
                    }
                } else if (Math.abs(current) == Math.abs(last)) {
                    stack.pop();
                    break;
                } else {
                    break;
                }
            }
        }
        int[] result = new int[stack.size()];
        for(int i = result.length - 1; i >= 0; i--){
            result[i] = stack.pop();
        }
        return result;
    }
}
