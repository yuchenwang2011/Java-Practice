75. Sort Colors My Submissions Question
Total Accepted: 85495 Total Submissions: 251688 Difficulty: Medium
Given an array with n objects colored red, white or blue, 
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.
Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, 
then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?

Answer:
public class Solution {
    public void sortColors(int[] nums) {
      //At first I wrote a quick sort, but i still have some problems
      //https://leetcode.com/discuss/17000/share-my-one-pass-constant-space-10-line-solution
      //https://leetcode.com/discuss/73086/concise-1-pass-java-solution
      if(nums == null || nums.length ==0){
          return;
      }
      
      int zeroPointer = 0, twoPointer = nums.length-1;
      for(int i = 0; i < nums.length; i++){
          if(nums[i] == 0){
              if(i != zeroPointer){
                swap(nums,i,zeroPointer); 
              }
              zeroPointer++;
          }
          if(nums[i] == 2 && i < twoPointer){
              swap(nums,i,twoPointer);
              i--; twoPointer--; //wait 1 more round at current place, if it's still a 2, swap again
          }
      }
      
    }
      public void swap(int[] nums, int first, int second){
          int tmp = nums[first];
          nums[first] = nums[second];
          nums[second] = tmp;
      }
}


//Here is the code I wrote in Second Round
public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int zeros = 0, twos = nums.length - 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                nums[i] = nums[zeros];
                nums[zeros++] = 0;
            } else if (nums[i] == 2 && twos >= i) {
                nums[i] = nums[twos];
                nums[twos--] = 2;
                i--;
            }
        }
    }
}

//update on May13 2019
//I totally don't understand my own answer above, here is my new answer
class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        
        int zeroStarts = 0;
        int twoEnds = nums.length - 1;

        int i = 0;
        while(i <= twoEnds){
            if(i > zeroStarts && nums[i] == 0){
                nums[i] = nums[zeroStarts];
                nums[zeroStarts++] = 0;
            } else if(i < twoEnds && nums[i] == 2){
                nums[i] = nums[twoEnds];
                nums[twoEnds--] = 2;
            } else {
                i++;
            }
        }
    }
}
