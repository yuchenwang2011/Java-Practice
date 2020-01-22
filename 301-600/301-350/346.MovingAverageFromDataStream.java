346. Moving Average from Data Stream
Easy

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 
Accepted 100,772 Submissions 146,762

Answer:
class MovingAverage {
    private int size;
    private Queue<Integer> queue;
    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }
    
    private double sum = 0;
    public double next(int val) {
        if(queue.size() == size) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return sum / queue.size();
    }
}
