1167. Minimum Cost to Connect Sticks
Medium

You have some sticks with positive integer lengths.
You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.  
You perform this action until there is one stick remaining.
Return the minimum cost of connecting all the given sticks into one stick in this way.

Example 1:
Input: sticks = [2,4,3]
Output: 14

Example 2:
Input: sticks = [1,8,3,5]
Output: 30
 
Constraints:
1 <= sticks.length <= 10^4
1 <= sticks[i] <= 10^4
Accepted 9,086 Submissions 14,802

Answer:
class Solution {
    public int connectSticks(int[] sticks) {
        int result = 0;
        if(sticks == null || sticks.length < 1) return result;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : sticks){
            pq.offer(i);
        }
        
        while(pq.size() > 1){
            int cost = pq.poll() + pq.poll();
            result += cost;
            pq.offer(cost);
        }
        
        return result;
    }
}
