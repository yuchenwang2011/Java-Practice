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
            if(citations[i] >= length - i) return length - i;
        }
        return 0;
    }
}


public class Solution {
    //Second answer inspired by this answer:
    //https://leetcode.com/discuss/66656/java-o-n-time-with-easy-explanation
    //https://leetcode.com/discuss/93819/java-bucket-sort-o-n-solution-with-detail-explanation
    public int hIndex(int[] citations) {
        int length = citations.length;
        int[] array = new int[length+1];
        //This is like a hashtable, put too large elemtents to the end
        for(int i = 0 ; i < length; i++){
            if(citations[i] > length) array[length] ++;
            else array[citations[i]]++; 
        }
        int result = 0;
        for(int i = array.length - 1; i >=0; i--){
            result = result + array[i];
            //Because array is actually from low to high,
            //it means we now have enough papers with higher citations
            //result here means the total number of papers that have more than i citations. i is h
            //here if you can't understand, look at the image in the second link
            if(result >= i) return i;
        }
        return 0;
    }
}
