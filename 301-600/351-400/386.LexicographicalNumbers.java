386. Lexicographical Numbers
Medium
Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

Example 1:
Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]

Example 2:
Input: n = 2
Output: [1,2]

Constraints:
1 <= n <= 5 * 104
Accepted 98.5K Submissions 160.5K Acceptance Rate 61.4%

Answer:
O(n)
class Solution{
    public List<Integer> lexicalOrder(int n){
        List<Integer> result = new ArrayList<>();
        if(n < 1) return result;
        
        int current = 1;
        for(int i = 1; i <= n; i++){
            result.add(current);
            if(current * 10 <= n){
                current *= 10;
            } else if(current % 10 != 9 && current + 1 <= n){
                current++;
            } else{
                while(current % 10 == 9 || current + 1 > n){
                    current /= 10;
                }
                current++;
            }
        }
        return result;
    }
}

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        if(n < 1) return result;

        for(int i = 1; i < 10; i++){
            dfs(i, n, result);
        }

        return result;
    }

    public void dfs(int current, int n, List<Integer> result){
        if(current > n) return;

        result.add(current);
        for(int i = 0; i < 10; i++){
            if(current * 10 + i > n){
                return;
            }
            dfs(current * 10 + i, n, result);
        }
    }
}
