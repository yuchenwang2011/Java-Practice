295. Find Median from Data Stream
Hard

Median is the middle value in an ordered integer list. 
If the size of the list is even, there is no middle value. 
So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3
[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:
void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 
Example:
addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 
Follow up:
If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?

Accepted 120,618 Submissions 318,528

Answer:
class MedianFinder {
    PriorityQueue<Long> small;
    PriorityQueue<Long> big;
    
    public MedianFinder() {
        small = new PriorityQueue<>();
        big = new PriorityQueue<>();
    }
    
    //这里的目的是争取让small和big平分所有的数，并且保持big总是多点
    //这样如果是奇数，big就是第一个。如果是偶数，就是big和small的第一个
    //想一个x y坐标轴，big就是个向上的抛物线。small就是个向下的抛物线
    //small的第一个，其实就是big的前一个
    public void addNum(int num) {
        big.offer((long) num);
        small.offer(-big.poll());
        if(big.size() < small.size()) big.offer(-small.poll());
    } 
    
    public double findMedian() {
        if(big.size() > small.size()) return big.peek();
        //注意这里是peek,不是poll，因为可能call这个find method好几次
        return (big.peek() + (-small.peek())) / 2.0;
    }
}
