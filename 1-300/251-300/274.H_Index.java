274. H-Index My Submissions QuestionEditorial Solution
Total Accepted: 29917 Total Submissions: 102569 Difficulty: Medium
Given an array of citations (each citation is a non-negative integer) of a researcher, 
write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: 
"A scientist has index h if h of his/her N papers have at least h citations each, 
and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher 
has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. 
Since the researcher has 3 papers with at least 3 citations each 
and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

Hint:

An easy approach is to sort the array first.
What are the possible values of h-index?
A faster approach is to use extra space.

Answer:
//这次是我自己的理解，就是纯粹根据定义，h本身是个index，所以相当于i的循环
//这个index h的citation也就是citations[h] >= N - h (根据定义no more than)
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int n = citations.length; 
        for(int h = 0; h < n; h++){
            if(citations[h] >= n - h) return n - h;
        }
        return 0;
    }
}



public class Solution {
    //This answer is inspired by this O(NlogN), no one can think up a O(N) in a real interview
    //https://leetcode.com/discuss/55958/my-easy-solution
    //Test case: [0,4,5,7],3 [0,3,5,7,8],3 [0,3,5,7,8,9],4, [0,3,5,7,8,9,10],5, [0,4,5,7,8],4 [0,4,5,7,8,9],4
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        for(int i = 0; i < length; i++){
            //From my understanding, after sorting, once the value in for ith element is higher than the rest of array,
            //that means all the numbers in front of this element, including their length, the number of rests is h
            //because they now all have a value >= h, and all the elements in front have values no bigger than C[i]
            //If they have one bigger than C[i], it will become the new C[i]. 
            //这里发现了length - i这么个值，到了临界值i这里才能大于等于他们，
            //也就是i - 1之前都不行， 也就是剩下的(n - (i - 1))才大于等于那个值，剩下的是index，
            //里面有多少数呢，就要+1，也就是(n - (i - 1) - 1) = n - i。你可以想个无关的，长度为4，减去index 0，你最后得减去1也就是三个值 
            //h index就是说，至少有h个数字，他们的引用不少于就是大于等于h个引用
            突然发现自己比后面的那堆的长度大了，说明后面的数都比这个长度大，根据定义这个长度就是h
            if(citations[i] >= length - i) return length - i;
        }
        return 0;
    }
}

1.bucket sort
So assume n is the total number of papers, if we have n+1 buckets, number from 0 to n, 
then for any paper with reference corresponding to the index of the bucket, we increment the count for that bucket. 
The only exception is that for any paper with larger number of reference than n, we put in the n-th bucket.
For example, given array [3,0,6,5,1], we have 6 buckets to contain how many papers have the corresponding index. 

2. Then we iterate from the back to the front of the buckets, whenever the total count exceeds the index of the bucket, 
meaning that we have the index number of papers that have reference greater than or equal to the index. 
Which will be our h-index result. The reason to scan from the end of the array is that we are looking for the greatest h-index. 

result就是有n篇文章，至少被引用了n次
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int c : citations) {
            if(c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for(int i = n; i >= 0; i--) {
            count += buckets[i];
            //有n篇文章，至少被引用了n次
            //为什么返回i不是count呢，因为想要返回最小的可能的h值
            if(count >= i) {
                return i;
            }
        }
        return 0;
    }
} 
