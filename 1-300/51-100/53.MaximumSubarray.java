53. Maximum Subarray My Submissions Question
Total Accepted: 93288 Total Submissions: 260778 Difficulty: Medium
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.
More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

Answer:
This is a very very good video tutorial, which introduces 3 methods, 
https://www.youtube.com/watch?v=ohHWQf1HDfU
0.DP method
1.Kadane's Algorithm O(N) (improved DP method)
2.Devide and Conquer O(Nlog(N))
3.Brute Force O(N^2)

//DP method
//https://leetcode.com/problems/maximum-subarray/solutions/20193/dp-solution-some-thoughts/
public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int currentMax = nums[0]; int finalMax = nums[0];
        for(int i = 1; i < nums.length; i++){
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            finalMax = Math.max(currentMax, finalMax);
        }
        return finalMax;
    }
}

//Brute Force Method
public int maxSubArray(int[] nums){
    if(nums == null || nums.length == 0){
        return 0;
    }
    int result = Integer.MIN_VALUE;
    for(int i = 0; i < nums.length ; i++){
        int tmpSum = 0;
        for(int size = i; size < nums.length; size++){
            tmpSum = tmpSum + nums[size];
            result = Math.max(tmpSum,result);
        }
    }
    return result;
}



//Divide and Conquer Method
public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int start = 0, end = nums.length-1;
        int max = divideNConquer(nums,start,end);
        return max;
    }
    
    public int divideNConquer(int[] nums, int start, int end){
        if(start == end){
            return nums[start];
        }
        //first find left max and right max, then find the middle connection max sum array
        int mid = start + (end -start)/2;
        int leftMax = divideNConquer(nums,start,mid);
        int rightMax = divideNConquer(nums,mid+1,end);
        
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        int tmpSum = 0;
        for(int i = mid; i >= start; i--) {
            tmpSum = tmpSum + nums[i];
            leftSum = Math.max(leftSum, tmpSum);
        }
        tmpSum = 0;
        for(int i = mid+1; i <= end; i++){
            tmpSum = tmpSum + nums[i];
            rightSum = Math.max(rightSum, tmpSum);
        }
        return Math.max(Math.max(leftMax,rightMax),leftSum+rightSum);
    }
}

