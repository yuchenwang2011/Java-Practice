162. Find Peak Element My Submissions Question
Total Accepted: 54742 Total Submissions: 167568 Difficulty: Medium
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.

Answer:
public class Solution {
    public int findPeakElement(int[] nums) {
        //I was inspired by this answer
        //https://leetcode.com/discuss/68999/java-solution-and-explanation-using-invariants
        //But this answer is same as mine actually
        //https://leetcode.com/discuss/56031/java-short-and-neat-code-10-line
        if(nums == null ||nums.length ==0){
            return 0;
        }
        if(nums.length ==1) return 0;
        int start = 0, end = nums.length-1;
        while(start < end){
            int mid = start + (end -start)/2;
            if( (start < end -1) &&nums[mid] > nums[mid -1] && nums[mid] > nums[mid+1]){
               return mid; 
            }
            if(nums[mid] < nums[mid+1]){
                start = mid+1;
            } else {
                end = mid;
            } //no equal case as question said num[i] ≠ num[i+1]
        }
        return start;
    }
}
//Test Case [1,2],[2,1]
/* The explanation
I find it useful to reason about binary search problems using invariants. While there are many solutions posted here, neither of them provide (in my opinion) a good explanation about why they work. I just spent some time thinking about this and I thought it might be a good idea to share my thoughts.

Assume we initialize left = 0, right = nums.length - 1. The invariant I'm using is the following:

nums[left - 1] < nums[left] && nums[right] > nums[right + 1]

That basically means that in the current interval we're looking, [left, right] the function started increasing to left and will eventually decrease at right. The behavior between [left, right] falls into the following 3 categories:

1) nums[left] > nums[left + 1]. From the invariant, nums[left - 1] < nums[left] => left is a peak

2) The function is increasing from left to right i.e. nums[left] < nums[left + 1] < .. < nums[right - 1] < nums[right]. From the invariant, nums[right] > nums[right + 1] => right is a peak

3) the function increases for a while and then decreases (in which case the point just before it starts decreasing is a peak) e.g. 2 5 6 3 (6 is the point in question)

As shown, if the invariant above holds, there is at least a peak between [left, right]. Now we need to show 2 things:

I) the invariant is initially true. Since left = 0 and right = nums.length - 1 initially and we know that nums[-1] = nums[nums.length] = -oo, this is obviously true

II) At every step of the loop the invariant gets reestablished. If we consider the code in the loop, we have mid = (left + right) / 2 and the following 2 cases:

a) nums[mid] < nums[mid + 1]. It turns out that the interval [mid + 1, right] respects the invariant (nums[mid] < nums[mid + 1] -> part of the cond + nums[right] > nums[right + 1] -> part of the invariant in the previous loop iteration)

b) nums[mid] > nums[mid + 1]. Similarly, [left, mid] respects the invariant (nums[left - 1] < nums[left] -> part of the invariant in the previous loop iteration and nums[mid] > nums[mid + 1] -> part of the cond)

As a result, the invariant gets reestablished and it will also hold when we exit the loop. In that case we have an interval of length 2 i.e. right = left + 1. If nums[left] > nums[right], using the invariant (nums[left - 1] < nums[left]), we get that left is a peak. Otherwise right is the peak (nums[left] < nums[right] and nums[right] < nums[right + 1] from the invariant).
*/
