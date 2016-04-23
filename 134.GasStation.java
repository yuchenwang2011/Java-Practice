134. Gas Station   My Submissions QuestionEditorial Solution
Total Accepted: 59964 Total Submissions: 219520 Difficulty: Medium
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas 
to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.

Answer:
public class Solution {
    //Got inspired by this answer, read the prool in the answer, you will understand finally
    //https://leetcode.com/discuss/4159/share-some-of-my-ideas
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length ) return -1;
        int tank = 0;
        int sum = 0;
        int start = 0;

        for(int i = 0; i < gas.length ; i++){
            tank = tank + gas[i] - cost[i];
            sum = sum + gas[i] - cost[i];
            if(tank < 0){
               start = i + 1;
               tank = 0;
            } 
        }
        if(sum < 0) return -1;
        return start;
    }
}
