Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 
different ways to solve this problem.

Answer:
public class Solution {
    //1234567-->7654321-->(567)(1234)
    public void rotate(int[] nums, int k) {
       if (k <= 0) {
           return;
       } else {
           k = k % nums.length;
           reverseArray(nums,0,nums.length-1);
           reverseArray(nums,0,k-1);
           reverseArray(nums,k,nums.length-1);
       }
    }
    
    public void reverseArray(int[] data, int first, int end){
        if(data.length == 0 || first > data.length || end > data.length || first < 0 || end < 0) {
            return;
        }
        int tmp;
        while(first < end) {
            tmp = data[first];
            data[first] = data[end];
            data[end] = tmp;
            first++;end--;
        }
    }
}

