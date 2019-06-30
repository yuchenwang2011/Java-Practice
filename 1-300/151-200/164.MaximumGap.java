164. Maximum Gap
Hard

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
Return 0 if the array contains less than 2 elements.

Example 1:
Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.

Example 2:
Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.

Note:
You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
Try to solve it in linear time/space.

class Solution {
    public int maximumGap(int[] nums) {
        int result = 0;
        if(nums == null || nums.length < 2) return result;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        
        int[] bucketMin = new int[nums.length - 1];
        int[] bucketMax = new int[nums.length - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == min || nums[i] == max) continue;
            int idx = (nums[i] - min) / gap;
            bucketMin[idx] = Math.min(bucketMin[idx], nums[i]);
            bucketMax[idx] = Math.max(bucketMax[idx], nums[i]);
        }
        
        int pre = min;
        for(int i = 0; i < nums.length - 1; i++){
            //it's possible some buckets have no value fall into it at all
            if(bucketMax[i] == Integer.MIN_VALUE && bucketMin[i] == Integer.MAX_VALUE) continue;
            //我开始一直不明白为什么不是bucketMax - pre, 后面换成bucketMin，这样第二个bucket的max值减去前一个bucket的min值才能达到最大的gap啊
            //其实这个想法不对，因为这里是要相邻两个数字的gap，如果是max-min就不是相邻的两个数字了
            //所以为了求相邻的，只能是前一个的max被第二个的min减
            result = Math.max(bucketMin[i] - pre, result);
            pre = bucketMax[i];
        }
        result = Math.max(result, max - pre);
        return result;
    }
}
