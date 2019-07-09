137. Single Number II   My Submissions QuestionEditorial Solution
Total Accepted: 81941 Total Submissions: 217895 Difficulty: Medium
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Answer:
//这个题没有什么难的，就这么记。就第一个ones需要点难度是用^，这个^是之前类似题都用过的了
//剩下的所有的东西都是用&来求的。
public class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int ones = 0, twos = 0, threes = 0;
        for(int i = 0; i < nums.length; i++){
            twos |= (ones & nums[i]);  //进位, 这里的ones&是为了提炼出nums里的第二次出现的1
            ones ^= nums[i];          //有1的就相当于进位了，没有1的就相当于提炼出1
            thress = ones & twos;      //如果ones和twos都是1，相当于1+2=3了，
            ones &= ~threes;           //如果threes有一位是1也就是发现了一个出现3次的数，~就是0， 所以把ones和twos那一位清零了，重头再来
            twos &= ~threes;
        }
        return ones;                  //因为single number就出现一次，所以肯定是最后的ones
    }
}
