287. Find the Duplicate Number
Medium

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:
Input: [1,3,4,2,2]
Output: 2

Example 2:
Input: [3,1,3,4,2]
Output: 3

Note:
1. You must not modify the array (assume the array is read only).
2. You must use only constant, O(1) extra space.
3. Your runtime complexity should be less than O(n2).
4. There is only one duplicate number in the array, but it could be repeated more than once.
Accepted 207,922 Submissions 411,412

Answer:
//两种方法都需要掌握，二分法n * logn，然后还有two pointer O(n)
//这次的二分没法用模板
//我们一直不是在寻找这个多余的数字到底在哪个位置idx，
//而是一直在算这个多余的数字到底是多少，因为值是固定的在1到n之间的。
// 1 3 4 2 2  
//start = 0, end = 5 => mid = 2, count = 3 > mid => 有不少数都比中间值小，那么这个重复的值肯定是在2或者2以下 
//start = 0, high = 2 => mid = 1, count = 1 > mid => 意味着没有数比中间值小，也就是很多数都比中间值大，那么这个重复的值肯定是在1以上的
//start = 2, high = 2, return 2
//return low
class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = (end - start) / 2 + start;
            int count = 0;
            for(int i = 0; i < nums.length; i++){
                //注意，这里是mid，不是nums[mid]
                if(nums[i] <= mid) count++;
            }
            //说明重复的数字肯定在[1,mid]，因为数出来的count多了起码一个
            if(count > mid) end = mid;
            else start = mid + 1; //说明mid值选的不好，比mid小的数字太少了，mid不够大
        }
        return start;
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
