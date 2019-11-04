731. My Calendar II
Medium

Implement a MyCalendarTwo class to store your events. 
A new event can be added if adding the event will not cause a triple booking.

Your class will have one method, book(int start, int end). Formally, 
this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.
A triple booking happens when three events have some non-empty intersection
(ie., there is some time that is common to all 3 events.)

For each call to the method MyCalendar.book, return true if the event can be 
added to the calendar successfully without causing a triple booking. 
Otherwise, return false and do not add the event to the calendar.

Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)

Example 1:
MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(50, 60); // returns true
MyCalendar.book(10, 40); // returns true
MyCalendar.book(5, 15); // returns false
MyCalendar.book(5, 10); // returns true
MyCalendar.book(25, 55); // returns true

Explanation: 
The first two events can be booked.  The third event can be double booked.
The fourth event (5, 15) can't be booked, because it would result in a triple booking.
The fifth event (5, 10) can be booked, as it does not use time 10 which is already double booked.
The sixth event (25, 55) can be booked, as the time in [25, 40) will be double booked with the third event;
the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
 
Note:
The number of calls to MyCalendar.book per test case will be at most 1000.
In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].
 
Accepted 29,813 Submissions 64,169
Answer:
//uses the same method as in 729
class MyCalendarTwo {
    private List<int[]> calendar;
    public MyCalendarTwo() {
        calendar = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        MyCalendar overlap = new MyCalendar();
        for(int[] book : calendar){
            //这里，第一段和第二段冲突了。把冲突那段拿出来，which is part of 第二段
            //去看看这段，有没有和其他的冲突，如果有，意味着第二段就因为这里跟其他的段有冲突了
            //所以不能再冲突一次了。所以第一段不能再要了
            if(Math.max(start, book[0]) < Math.min(end, book[1])) {
                if(!overlap.book(Math.max(start, book[0]), Math.min(end, book[1]))) {
                    return false;
                }
            }
        }
        calendar.add(new int[]{start, end});
        return true;
    }
    
    class MyCalendar{
        private List<int[]> calendar;
        public MyCalendar(){
            calendar = new ArrayList<>();
        }
        
        public boolean book(int start, int end){
            if(start > end) return false;
            for(int[] book : calendar){
                if(Math.max(start, book[0]) < Math.min(end, book[1])) return false;
            }
            calendar.add(new int[]{start, end});
            return true;
        }
    }
}
