4. Median of Two Sorted Arrays
Hard
There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
You may assume nums1 and nums2 cannot be both empty.
Example 1:
nums1 = [1, 3]
nums2 = [2]
The median is 2.0

Example 2:
nums1 = [1, 2]
nums2 = [3, 4]
The median is (2 + 3)/2 = 2.5

Solution:
(My own solution)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null) return 0d;
        
        int[] nums = mergeTwoSortedArrays(nums1, nums2);
        System.out.println(Arrays.toString(nums));
        double result = searchMedian(nums);
        
        return result;        
    }
    
    private int[] mergeTwoSortedArrays(int[] nums1, int[] nums2){
        if(nums1 == null || nums1.length == 0) return nums2;
        if(nums2 == null || nums2.length == 0) return nums1;
        
        int[] nums = new int[nums1.length + nums2.length];
        
        int start1 = 0;
        int start2 = 0;
        int start3 = 0;
        while(start1 < nums1.length && start2 < nums2.length){
            if(nums1[start1] < nums2[start2]){
                nums[start3++] = nums1[start1++];
            } else{
                nums[start3++] = nums2[start2++];
            }
        }
        while(start1 < nums1.length){
            nums[start3++] = nums1[start1++];
        }
        
        while(start2 < nums2.length){
            nums[start3++] = nums2[start2++];
        }
        return nums;
    }
    
    private double searchMedian(int[] nums){
        if(nums == null || nums.length == 0) return 0d;
        
        if(nums.length % 2 == 1) {
            return nums[nums.length / 2];
        }
        
        return (nums[nums.length / 2 - 1] + nums[nums.length / 2 ]) / 2d;
    }
}

Solution2:
Followed this tutorial: https://www.youtube.com/watch?v=LPFhl65R7ww
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if(length1 > length2) return findMedianSortedArrays(nums2, nums1);
        
        int start = 0;
        int end = length1;
        
        while(start <= end){
            int partition1 = start + (end - start) / 2;
            int partition2 = (length1 + length2 + 1) / 2 - partition1;
            
            int left1 = partition1 == 0? Integer.MIN_VALUE : nums1[partition1 - 1];
            int right1 = partition1 == length1? Integer.MAX_VALUE : nums1[partition1];
            
            int left2 = partition2 == 0? Integer.MIN_VALUE : nums2[partition2 - 1];
            int right2 = partition2 == length2? Integer.MAX_VALUE : nums2[partition2];
            
            if(left1 <= right2 && left2 <= right1) {
                if((length1 + length2) %2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2d;
                } else {
                    return (double) Math.max(left1, left2);
                }
            } else if (left1 > right2){
                end = partition1 - 1;
            } else {
                start = partition1 + 1;
            }
        }
        return 0d;
    }
}
