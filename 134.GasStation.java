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
    //加上一点自己的理解，为什么start = i + 1。 有一些证明是比较严谨的，证明i+1为什么是合理的。
    //我争取想的农民一些，好懂一点。比如从第0个油站开始，连第1个油站它都到不了，说明这个油站是没希望了。
    //既然第一个没希望了，我们就从第二个开始试吧。假设第二个油站争气了一点，到了第4个了之后，第五个到不了了。
    //那么第2个油站肯定没希望了，他连家门口几步都走不出去。那么第三个肯定也是没出息的了，
    //因为第2个油站既然能到第3个，说明它开始还是争气的，sum肯定是>=0的，这样才能到第3个啊
    //既然第二个开始争气，最后还是没有到第四个，说明第三个不争气，第四个也不争气。所以从第五个开始试吧。
    //然后发现第五个很争气，一直撸到结尾最后一个油站，说明他从第五段路以后是争气的。这样就开始看第五个以前的部分
    //拖不拖后腿了。第五段路以后争气就是sum>=0,假如它前面这段路的sum0+sum也能>=0，他就成功了，也就是说
    //对于它，整个的路程的sum是>=0的，它就成功了
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
