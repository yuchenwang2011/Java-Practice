528. Random Pick with Weight
Medium

Given an array w of positive integers, where w[i] describes the weight of index i, 
write a function pickIndex which randomly picks an index in proportion to its weight.

Note:
1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.

Example 1:
Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]

Example 2:
Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
Explanation of Input Syntax:
The input is two lists: the subroutines called and their arguments. 
Solution's constructor has one argument, the array w. pickIndex has no arguments. 
Arguments are always wrapped with a list, even if there aren't any.

Accepted 40,597 Submissions 94,011
Answer:
//https://leetcode.com/problems/random-pick-with-weight/solutions/154044/java-accumulated-freq-sum-binary-search/
class Solution {
    //这题问的是随机出来一个index出来，based on权重
    //所以我们按照权重随机出来一个数字，然后看看能落在什么权重区域里,就是最后的index
    private int[] w;
    
    public Solution(int[] w) {
        for(int i = 1; i < w.length; i++){
            w[i] += w[i - 1];
        }
        this.w = w;
    }
    
    public int pickIndex() {
        //w[] = {2,5,3,4} => wsum[] = {2,7,10,14}
        //then get random val random.nextInt(14)+1, idx is in range [1,14]
        int random = new Random().nextInt(w[w.length - 1]) + 1;
        int start = 0;
        int end = w.length - 1;
        while(start < end){
            int mid = (end - start) / 2 + start;
            if(w[mid] == random) return mid;
            else if(w[mid] < random) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}
