60. Permutation Sequence . Medium
The set [1,2,3,...,n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
    
Given n and k, return the kth permutation sequence.

Note:
Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.

Example 1:
Input: n = 3, k = 3
Output: "213"
    
Example 2:
Input: n = 4, k = 9
Output: "2314"

Answer:
class Solution {
    public String getPermutation(int n, int k) {
        String result = "";
        if(n <= 0 || k <= 0) return result;
        
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }
        
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for(int i = 1; i <= n; i++){
            fact[i] = fact[i - 1] * i;
        }
        
        //n = 3, k = 1/2: when fact = 2, k/2 corresponse to 0/1. nums[0] != nums[1]
        //so k - 1, k = 0/1, k /2 = 0/0, nums[0] = nums[0], we get the first digit index
        k = k - 1;
        for(int i = n - 1; i >= 0; i--){
            int index = k / fact[i];
            result += nums.get(index);
            nums.remove(index);
            k = k % fact[i];
        }
        
        return result;
    }
}
