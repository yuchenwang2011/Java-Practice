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
O(log(min(len1, len2)))
Followed this tutorial: https://www.youtube.com/watch?v=LPFhl65R7ww
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n) return findMedianSortedArrays(nums2, nums1);
        
        int start = 0;
        int end = m;
        //注意这里end是m，这个模板要注意
        while(start <= end){
            //只要关注mid1和平常一样，mid2很好推导
            int mid1 = (end - start) / 2 + start;
            int mid2 = (m + n + 1) / 2 - mid1;
            
            //关于这个start 和 end，别想太复杂，他们就代表着他们的左边有几个而已，start = 0就是start左边有0个
            //所以5个元素，partition1 = 2， 就是左边有2个。如果往左挪，end = partition - 1 = 1， 就是end左边有1个
            //如果往右挪，start = partition + 1 = 3. 就是start左边有三个。
            int left1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int right1 = mid1 == m ? Integer.MAX_VALUE : nums1[mid1];
            
            int left2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int right2 = mid2 == n ? Integer.MAX_VALUE : nums2[mid2];
            if(left1 <= right2 && left2 <= right1) {
                if((m + n) % 2 == 0) {
                    return ((double) Math.max(left1, left2) + Math.min(right1, right2)) / 2;
                } else {
                    return (double) Math.max(left1, left2);
                }
            } else if(left1 > right2){
                end = mid1 - 1;
            } else {
                start = mid1 + 1;
            }
        }
        return (double) nums1[start];
    }
}
