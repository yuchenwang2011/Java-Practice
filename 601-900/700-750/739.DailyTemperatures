739. Daily Temperatures
Medium 11.7K 256

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days 
you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]
 
Constraints:
1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100
Accepted 700.9K Submissions 1.1M Acceptance Rate 65.9%

Answer:
//这个方法绝了
//https://leetcode.com/problems/daily-temperatures/solutions/109832/java-easy-ac-solution-with-stack
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) return new int[0];
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            
            stack.push(i);
        }
        return result;
    }
}
