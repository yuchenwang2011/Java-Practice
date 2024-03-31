1570. Dot Product Of Two Sparse Vectors
Given two sparse vectors, compute their dot product.
Implement class SparseVector:

SparseVector(nums) Initializes the object with the vector nums
dotProduct(vec) Compute the dot product between the instance of SparseVector and vec
A sparse vector is a vector that has mostly zero values, you should store the sparse vector 
  efficiently and compute the dot product between two SparseVector.
Follow up: What if only one of the vectors is sparse?

Example 1:
Input: nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
Output: 8
Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8
Example 2:

Input: nums1 = [0,1,0,0,0], nums2 = [0,0,0,0,2]
Output: 0
Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
v1.dotProduct(v2) = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0

Example 3:
Input: nums1 = [0,1,0,0,2,0,0], nums2 = [1,0,0,0,3,0,4]
Output: 6
 
Constraints:
n == nums1.length == nums2.length
1 <= n <= 10^5
0 <= nums1[i], nums2[i] <= 100

Accepted 242.6K Submissions 269.9K Acceptance Rate 89.9%

Answer:
//https://leetcode.com/problems/dot-product-of-two-sparse-vectors/solutions/1522271/java-o-n-solution-using-two-pointers-with-detailed-explanation-and-follow-up/
class SparseVector {
    List<int[]> list;

    SparseVector(int[] nums) {
        list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            list.add(new int[]{i, nums[i]});
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        int p = 0, q = 0;
        while(p < list.size() && q < vec.list.size()){
            if(list.get(p)[0] == vec.list.get(q)[0]){
                result += list.get(p)[1] * vec.list.get(q)[1];
                p++; q++;
            } else if (list.get(p)[0] < vec.list.get(q)[0]){
                p++;
            } else {
                q++;
            }
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
