974. Subarray Sums Divisible by K
Medium

Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.

Example 1:
Input: A = [4,5,0,-2,-3,1], K = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by K = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 
Note:
1 <= A.length <= 30000
-10000 <= A[i] <= 10000
2 <= K <= 10000

Accepted 24,187 Submissions 50,834

Answer:
//presum
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int result = 0;
        if(A == null || A.length == 0) return result;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(sum, 1);
        for(int num : A){
            sum = (sum + num) % K;
            if(sum < 0) sum += K;
            //如果两个sum一样，说明这个sum减去以前的sum，中间的就是余数为0的
            //试试[1,4] / k = 4
            if(map.containsKey(sum)) result += map.get(sum);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
