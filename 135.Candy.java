135. Candy
Hard

There are N children standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:
Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.
             
Answer:
https://leetcode.com/problems/candy/discuss/42794/Simple-O(n)-Java-solution-with-comments
class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        int[] result = new int[ratings.length];
        Arrays.fill(result, 1);
        
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]) {
                result[i] = result[i - 1] + 1;
            }
        }
        
        // for(int i : result){
        //     System.out.print(i);
        // }
        
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1] && result[i] <= result[i + 1]) {
                result[i] = result[i + 1] + 1;
            }
        }
        
//         System.out.println("");
//         for(int i : result){
//             System.out.print(i);
//         }
        
        int sum = 0;
        for(int i : result){
            sum+= i;
        }
        return sum;
    }
}
